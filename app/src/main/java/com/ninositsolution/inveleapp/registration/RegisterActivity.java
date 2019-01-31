package com.ninositsolution.inveleapp.registration;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.ninositsolution.inveleapp.login.LoginActivity;
import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity implements IRegister {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setRegister(new RegisterVM(getApplicationContext(), this));
        binding.executePendingBindings();
    }

    @Override
    public void onEmailLayoutClicked() {

        binding.viewMobile.setVisibility(View.INVISIBLE);
        binding.viewEmail.setVisibility(View.VISIBLE);
        binding.emailRegister.setVisibility(View.VISIBLE);
        binding.mobileRegister.setVisibility(View.GONE);

    }

    @Override
    public void onMobileLayoutClicked() {

        binding.viewMobile.setVisibility(View.VISIBLE);
        binding.viewEmail.setVisibility(View.INVISIBLE);
        binding.emailRegister.setVisibility(View.GONE);
        binding.mobileRegister.setVisibility(View.VISIBLE);

    }

    @Override
    public void onEmailContinueClicked() {
        binding.registerLayout.setVisibility(View.GONE);
        binding.otpLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void onOtpContinueClicked() {

    }

    @Override
    public void onMobileContinueClicked() {
        binding.registerLayout.setVisibility(View.GONE);
        binding.otpLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void updateTimer(String time) {
        binding.timer.setText(time);

        if (time.equalsIgnoreCase("try again"))
            binding.resend.setEnabled(true);
    }

    @Override
    public void onResendClicked() {

    }

    @Override
    public void onUserClicked() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void onUser2Clicked() {
        startActivity(new Intent(this, LoginActivity.class));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (binding.otpLayout.getVisibility() == View.VISIBLE)
        {
            if (binding.viewMobile.getVisibility() == View.VISIBLE)
                binding.viewMobile.setVisibility(View.INVISIBLE);

            if (binding.mobileRegister.getVisibility() == View.VISIBLE)
                binding.mobileRegister.setVisibility(View.GONE);

            if (binding.emailRegister.getVisibility() == View.GONE)
                binding.emailRegister.setVisibility(View.VISIBLE);

            if (binding.viewEmail.getVisibility() == View.INVISIBLE)
                binding.viewEmail.setVisibility(View.VISIBLE);
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        if (binding.otpLayout.getVisibility() == View.VISIBLE)
        {
            if (binding.viewMobile.getVisibility() == View.VISIBLE)
                binding.viewMobile.setVisibility(View.INVISIBLE);

            if (binding.mobileRegister.getVisibility() == View.VISIBLE)
                binding.mobileRegister.setVisibility(View.GONE);

            if (binding.emailRegister.getVisibility() == View.GONE)
                binding.emailRegister.setVisibility(View.VISIBLE);

            if (binding.viewEmail.getVisibility() == View.INVISIBLE)
                binding.viewEmail.setVisibility(View.VISIBLE);
        }
    }
}
