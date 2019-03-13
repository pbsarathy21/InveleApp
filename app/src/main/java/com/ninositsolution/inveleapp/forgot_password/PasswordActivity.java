package com.ninositsolution.inveleapp.forgot_password;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ninositsolution.inveleapp.login.LoginActivity;
import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityPasswordBinding;

public class PasswordActivity extends AppCompatActivity implements IPassword {

    ActivityPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_password);
        //binding.setPassword(new PasswordVM(getApplicationContext(), this));
        binding.executePendingBindings();

    }

    @Override
    public void onResetClicked() {
        binding.passEmailLayout.setVisibility(View.GONE);
        binding.passPassLayout.setVisibility(View.VISIBLE);
        binding.passHeader.setText("Change Password");
    }

    @Override
    public void onSubmitClicked() {

    }

    @Override
    public void onBackClicked() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
