package com.ninositsolution.inveleapp.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.cart.CartActivity;
import com.ninositsolution.inveleapp.databinding.ActivityLoginBinding;
import com.ninositsolution.inveleapp.forgot_password.PasswordActivity;
import com.ninositsolution.inveleapp.home.HomeActivity;
import com.ninositsolution.inveleapp.registration.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);






        binding.setILogin(new ILogin() {
            @Override
            public void onForgotClicked() {
                startActivity(new Intent(LoginActivity.this, PasswordActivity.class));
            }

            @Override
            public void onLoginEmailClicked() {
                startActivity(new Intent(LoginActivity.this, CartActivity.class));
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
}
