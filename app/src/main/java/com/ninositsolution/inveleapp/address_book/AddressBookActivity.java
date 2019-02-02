package com.ninositsolution.inveleapp.address_book;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.add_address.AddAddressActivity;
import com.ninositsolution.inveleapp.databinding.ActivityAddressBookBinding;
import com.ninositsolution.inveleapp.edit_address.EditAddressActivity;

public class AddressBookActivity extends AppCompatActivity implements IAddressBook{

    ActivityAddressBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_address_book);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_address_book);
        binding.setAddressBook(new AddressBookVM(getApplicationContext(), this));
    }

    @Override
    public void onAddAddressClicked() {

        startActivity(new Intent(this, AddAddressActivity.class));

    }

    @Override
    public void onBackClicked() {

        super.onBackPressed();

    }

    @Override
    public void onEditClicked() {
        startActivity(new Intent(this, EditAddressActivity.class));
    }
}
