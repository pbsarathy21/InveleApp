package com.ninositsolution.inveleapp.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityLoginBinding;
import com.ninositsolution.inveleapp.forgot_password.PasswordActivity;
import com.ninositsolution.inveleapp.registration.RegisterActivity;
import com.ninositsolution.inveleapp.utils.Constants;
import com.ninositsolution.inveleapp.utils.Session;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 234;

    private static final String TAG = "LoginActivity";
    ActivityLoginBinding binding;
    LoginVM loginVMGlobal;

    GoogleSignInClient mGoogleSignInClient;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        initGoogle();

        binding.mobileLoginEdit.addTextChangedListener(new GenericTextWatcher(binding.mobileLoginEdit));
        //binding.otpLoginEdit.addTextChangedListener(new GenericTextWatcher(binding.otpLoginEdit));

        loginVMGlobal = ViewModelProviders.of(this).get(LoginVM.class);

        binding.setLogin(loginVMGlobal);

        binding.setLifecycleOwner(this);



        binding.setILogin(new ILogin() {
            @Override
            public void onForgotClicked() {
                startActivity(new Intent(LoginActivity.this, PasswordActivity.class));
            }

            @Override
            public void onLoginEmailClicked() {
                //startActivity(new Intent(LoginActivity.this, CartActivity.class));

                int status = loginVMGlobal.emailValidations();

                if (status == Constants.EMAIL_EMPTY)
                {
                    binding.loginUsername.setError("required");
                    binding.loginUsername.requestFocus();

                } else if (status == Constants.PASSWORD_EMPTY)
                {

                    binding.loginPassword.setError("required");
                    binding.loginPassword.requestFocus();

                } else if (status == Constants.SUCCESS)
                {
                    showProgressBar();

                    loginVMGlobal.loginViaEmail();

                    loginVMGlobal.getLoginVMMutableLiveData().observe(LoginActivity.this, new Observer<LoginVM>() {
                        @Override
                        public void onChanged(@Nullable LoginVM loginVM) {

                            if (loginVM.status.get().equalsIgnoreCase("success"))
                            {
                                hideProgressBar();

                                Toast.makeText(LoginActivity.this, ""+loginVM.msg.get(), Toast.LENGTH_SHORT).show();

                                Session.setUserId(String.valueOf(loginVM.user.get().id),LoginActivity.this);
                                Log.i(TAG, "User_id : "+loginVM.user.get().id);
                            } else
                            {
                                hideProgressBar();
                                Toast.makeText(LoginActivity.this, ""+loginVM.msg.get(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else
                {
                    Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

          /*  @Override
            public void onResendCodeClicked() {
                startActivity(new Intent(LoginActivity.this, CartActivity.class));
            }
*/
            @Override
            public void onLoginPhoneClicked() {

                int status = loginVMGlobal.mobileValidations();

                if (status == Constants.MOBILE_NO_EMPTY)
                {

                } else if (status == Constants.OTP_EMPTY)
                {

                } else if (status == Constants.SUCCESS)
                {

                } else
                {
                    Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNewUserClicked() {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }

            @Override
            public void onLoginWithClicked() {
                if (binding.loginWith.getText().toString().equalsIgnoreCase("login with sms"))
                {
                    binding.loginEmail.setVisibility(View.GONE);
                    binding.loginMobile.setVisibility(View.VISIBLE);
                    binding.loginWith.setText("Login with Email");
                }

                else
                {
                    binding.loginEmail.setVisibility(View.VISIBLE);
                    binding.loginMobile.setVisibility(View.GONE);
                    binding.loginWith.setText("Login with SMS");
                }
            }

            @Override
            public void onFacebookClicked() {

            }

            @Override
            public void onGoogleClicked() {

                showProgressBar();

                Intent signInIntent = mGoogleSignInClient.getSignInIntent();

                startActivityForResult(signInIntent, RC_SIGN_IN);

            }

            @Override
            public void onSendOtpClicked() {

                int status = loginVMGlobal.mobileAloneValidations();

                if (status == Constants.MOBILE_NO_EMPTY)
                {
                    binding.mobileLoginEdit.setError("required");

                } else if (status == Constants.SUCCESS){

                    showProgressBar();
                    loginVMGlobal.sendOtpApi(Session.getDevice_id(LoginActivity.this));

                    loginVMGlobal.getMobileSendOtpLiveData().observe(LoginActivity.this, new Observer<LoginVM>() {
                        @Override
                        public void onChanged(@Nullable LoginVM loginVM) {

                            if (!loginVM.status.get().isEmpty())
                            {
                                if (loginVM.status.get().equalsIgnoreCase("success"))
                                {
                                    hideProgressBar();
                                    Toast.makeText(LoginActivity.this, ""+loginVM.otp.get(), Toast.LENGTH_SHORT).show();
                                    loginVM.status.set("");
                                    loginVMGlobal.otp_code.set(String.valueOf(loginVM.otp.get()));

                                } else
                                {
                                    hideProgressBar();
                                    Toast.makeText(LoginActivity.this, ""+loginVM.msg.get(), Toast.LENGTH_SHORT).show();
                                    loginVM.status.set("");
                                }
                            }
                        }
                    });

                } else
                {
                    Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onResendClicked() {

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the requestCode is the Google Sign In code that we defined at starting
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                //authenticating with firebase
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                hideProgressBar();
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else
        {
            hideProgressBar();
            Toast.makeText(this, "User permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        //getting the auth credential
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        //Now using firebase we are signing in the user here
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            //Toast.makeText(LoginActivity.this, "User Signed In", Toast.LENGTH_SHORT).show();

                            Log.i(TAG, "user_name : "+user.getDisplayName());
                            Log.i(TAG, "user_email : "+user.getEmail());
                            Log.i(TAG, "user_phone : "+user.getPhoneNumber());
                            Log.i(TAG, "user_uid : "+user.getUid());
                            Log.i(TAG, "user_photo : "+user.getPhotoUrl());

                            if (user.getDisplayName() != null)
                            {
                                Session.setUsername(user.getDisplayName(), LoginActivity.this);
                            }

                            if (user.getEmail() != null)
                            {
                                Session.setUserEmail(user.getEmail(), LoginActivity.this);
                            }

                            if (user.getPhoneNumber() != null)
                            {
                                Session.setUserPhone(user.getPhoneNumber(), LoginActivity.this);
                            }

                            if (user.getUid() != null)
                            {
                                Session.setUserUid(user.getUid(), LoginActivity.this);
                            }

                            if (user.getPhotoUrl() != null)
                            {
                                Session.setUserPhoto(user.getPhotoUrl().toString(), LoginActivity.this);
                            }

                            loginVMGlobal.googleLoginApi(
                                    Session.getUserName(LoginActivity.this),
                                    Session.getUserPhone(LoginActivity.this),
                                    Session.getUserEmail(LoginActivity.this),
                                    Session.getUserUid(LoginActivity.this),
                                    Session.getDevice_id(LoginActivity.this)
                                    );


                            loginVMGlobal.getGoogleLoginLiveData().observe(LoginActivity.this, new Observer<LoginVM>() {
                                @Override
                                public void onChanged(@Nullable LoginVM loginVM) {

                                    if (!loginVM.status.get().isEmpty())
                                    {
                                        if (loginVM.status.get().equalsIgnoreCase("success"))
                                        {
                                            hideProgressBar();
                                            Toast.makeText(LoginActivity.this, ""+loginVM.msg.get(), Toast.LENGTH_SHORT).show();
                                            loginVM.status.set("");
                                        } else
                                        {
                                            hideProgressBar();
                                            Toast.makeText(LoginActivity.this, "Api Error", Toast.LENGTH_SHORT).show();
                                            loginVM.status.set("");
                                        }
                                    }
                                }
                            });


                        } else {

                            hideProgressBar();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }


    private void initGoogle() {

        FirebaseApp.initializeApp(this);

        mAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void showProgressBar()
    {
        if (binding.loginProgress.getVisibility() == View.GONE)
            binding.loginProgress.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar()
    {
        if (binding.loginProgress.getVisibility() == View.VISIBLE)
            binding.loginProgress.setVisibility(View.GONE);
    }

    public class GenericTextWatcher implements TextWatcher
    {

        private View view;

        public GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            String text = s.toString();

           if (view.getId() == R.id.mobile_login_edit)
           {
               if (text.length() > 4)
               {
                   binding.sendOtp.setEnabled(true);
                   binding.sendOtp.setTextColor(getResources().getColor(R.color.colorPrimary));
               }
               else {
                   binding.sendOtp.setEnabled(false);
                   binding.sendOtp.setTextColor(getResources().getColor(R.color.star_grey));
               }
           }

         /*   if (view.getId() == R.id.otp_login_edit)
            {
                if (text.length() == 4)
                {
                    binding.resendTimerText.setEnabled(true);
                    binding.resendTimerText.setTextColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    binding.resendTimerText.setEnabled(false);
                    binding.resendTimerText.setTextColor(getResources().getColor(R.color.star_grey));
                }
            }
*/
        }
    }
}
