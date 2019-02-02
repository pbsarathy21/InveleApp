package com.ninositsolution.inveleapp.add_address;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityAddAddressBinding;

public class AddAddressActivity extends AppCompatActivity implements IAddAddress{

    ActivityAddAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_address);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_address);
        binding.setAddAddress(new AddAddressVM(getApplicationContext(), this));
    }

    @Override
    public void onBackClicked() {
        super.onBackPressed();
    }
}
