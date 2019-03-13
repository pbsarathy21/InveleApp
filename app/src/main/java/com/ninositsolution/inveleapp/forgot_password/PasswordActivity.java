package com.ninositsolution.inveleapp.forgot_password;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ninositsolution.inveleapp.login.LoginActivity;
import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityPasswordBinding;
import com.ninositsolution.inveleapp.utils.Constants;

public class PasswordActivity extends AppCompatActivity{

    ActivityPasswordBinding binding;
    PasswordVM passwordVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_password);
        passwordVM = ViewModelProviders.of(this).get(PasswordVM.class);
        binding.setPassword(passwordVM);
        binding.setLifecycleOwner(this);

        binding.setIPassword(new IPassword() {
            @Override
            public void onResetClicked() {

                int status = passwordVM.forgotPasswordEmailValidation();

                if (status == Constants.EMAIL_EMPTY)
                {
                    binding.forgotPasswordEmail.setError("Required");
                    binding.forgotPasswordEmail.requestFocus();
                }

                else if (status == Constants.SUCCESS)
                {
                    showProgressBar();
                    passwordVM.forgotPasswordApi();

                    passwordVM.getPasswordVMMutableLiveData().observe(PasswordActivity.this, new Observer<PasswordVM>() {
                        @Override
                        public void onChanged(@Nullable PasswordVM passwordVM) {

                            if (!passwordVM.status.get().isEmpty())
                            {
                                hideProgressBar();
                                Toast.makeText(PasswordActivity.this, ""+passwordVM.status.get(), Toast.LENGTH_SHORT).show();
                                passwordVM.status.set("");
                            }
                        }
                    });

                } else
                {
                    Toast.makeText(PasswordActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }








            }

            @Override
            public void onSubmitClicked() {

            }

            @Override
            public void onBackClicked() {

            }
        });


    }

    private void showProgressBar()
    {
        if (binding.forgotProgress.getVisibility() == View.GONE)
            binding.forgotProgress.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar()
    {
        if (binding.forgotProgress.getVisibility() == View.VISIBLE)
            binding.forgotProgress.setVisibility(View.GONE);
    }


}
