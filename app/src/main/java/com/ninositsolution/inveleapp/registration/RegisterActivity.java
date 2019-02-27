package com.ninositsolution.inveleapp.registration;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityRegisterBinding;
import com.ninositsolution.inveleapp.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        binding.setIRegister(new IRegister() {
            @Override
            public void onEmailClicked() {
                swapRegistrationVisibility();
            }

            @Override
            public void onMobileClicked() {
                swapRegistrationVisibility();
            }

            @Override
            public void onUserClicked() {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }

            @Override
            public void onEmailContinueClicked() {
                getOtpLayout();
            }

            @Override
            public void onUser2Clicked() {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }

            @Override
            public void onMobileContinueClicked() {
                getOtpLayout();
            }

            @Override
            public void onResendClicked() {

            }

            @Override
            public void onOtpContinueClicked() {
                getBackRegistrationVisibility();
            }

            @Override
            public void onFacebookClicked() {

            }

            @Override
            public void onGoogleClicked() {

            }
        });
    }


    private void getBackRegistrationVisibility() {

        if (binding.otpLayout.getVisibility() == View.VISIBLE)
        {
            binding.otpLayout.setVisibility(View.GONE);
            binding.registerLayout.setVisibility(View.VISIBLE);

            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) binding.cardRegister.getLayoutParams();
            layoutParams.setMargins(36, 250, 36, 0);
            binding.cardRegister.requestLayout();
        }
    }

    private void getOtpLayout() {

        if (binding.registerLayout.getVisibility() == View.VISIBLE)
        {
            binding.registerLayout.setVisibility(View.GONE);
            binding.otpLayout.setVisibility(View.VISIBLE);

            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) binding.cardRegister.getLayoutParams();
            layoutParams.setMargins(36, 475, 36, 0);
            binding.cardRegister.requestLayout();
        }

    }

    private void swapRegistrationVisibility() {

        if (binding.emailRegister.getVisibility() == View.VISIBLE)
        {
            binding.emailHead.setTextColor(getResources().getColor(R.color.text_color));
            binding.mobileHead.setTextColor(getResources().getColor(R.color.colorPrimary));
            binding.emailRegister.setVisibility(View.GONE);
            binding.viewEmail.setVisibility(View.INVISIBLE);
            binding.mobileRegister.setVisibility(View.VISIBLE);
            binding.viewMobile.setVisibility(View.VISIBLE);
        } else
        {
            binding.mobileHead.setTextColor(getResources().getColor(R.color.text_color));
            binding.emailHead.setTextColor(getResources().getColor(R.color.colorPrimary));
            binding.mobileRegister.setVisibility(View.GONE);
            binding.viewMobile.setVisibility(View.INVISIBLE);
            binding.emailRegister.setVisibility(View.VISIBLE);
            binding.viewEmail.setVisibility(View.VISIBLE);
        }
    }

   /*
    @Override
    public void updateTimer(String time) {
        binding.timer.setText(time);

        if (time.equalsIgnoreCase("try again"))
            binding.resend.setEnabled(true);
    }

    }*/
}
