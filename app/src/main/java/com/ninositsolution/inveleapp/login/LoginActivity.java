package com.ninositsolution.inveleapp.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.cart.CartActivity;
import com.ninositsolution.inveleapp.databinding.ActivityLoginBinding;
import com.ninositsolution.inveleapp.forgot_password.PasswordActivity;
import com.ninositsolution.inveleapp.registration.RegisterActivity;
import com.ninositsolution.inveleapp.utils.Constants;
import com.ninositsolution.inveleapp.utils.Session;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginVM loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginVM = ViewModelProviders.of(this).get(LoginVM.class);

        binding.setLogin(loginVM);

        binding.setLifecycleOwner(this);



        binding.setILogin(new ILogin() {
            @Override
            public void onForgotClicked() {
                startActivity(new Intent(LoginActivity.this, PasswordActivity.class));
            }

            @Override
            public void onLoginEmailClicked() {
                //startActivity(new Intent(LoginActivity.this, CartActivity.class));

                int status = loginVM.emailValidations();

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

                    loginVM.loginViaEmail();

                    loginVM.getLoginVMMutableLiveData().observe(LoginActivity.this, new Observer<LoginVM>() {
                        @Override
                        public void onChanged(@Nullable LoginVM loginVM) {

                            hideProgressBar();

                            Toast.makeText(LoginActivity.this, ""+loginVM.msg.get(), Toast.LENGTH_SHORT).show();

                            Session.setUserId(String.valueOf(loginVM.users.get().id),LoginActivity.this);
                        }
                    });

                } else
                {
                    Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onResendCodeClicked() {
                startActivity(new Intent(LoginActivity.this, CartActivity.class));
            }

            @Override
            public void onLoginPhoneClicked() {

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

            }
        });

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
}
