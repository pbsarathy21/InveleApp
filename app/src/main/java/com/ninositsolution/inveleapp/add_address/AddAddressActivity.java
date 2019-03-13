package com.ninositsolution.inveleapp.add_address;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ninositsolution.inveleapp.R;
import com.ninositsolution.inveleapp.databinding.ActivityAddAddressBinding;
import com.ninositsolution.inveleapp.registration.RegisterVM;
import com.ninositsolution.inveleapp.utils.Constants;
import com.ninositsolution.inveleapp.utils.Session;

public class AddAddressActivity extends AppCompatActivity {

    ActivityAddAddressBinding binding;
    AddAddressVM addAddressVM;
    public static final String TAG = AddAddressActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_address);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_address);

        addAddressVM = ViewModelProviders.of(this).get(AddAddressVM.class);

        binding.setAddAddress(addAddressVM);
        binding.setLifecycleOwner(this);

        binding.setIAddAddress(new IAddAddress() {
            @Override
            public void onBackClicked() {


            }

            @Override
            public void onLocateClicked() {

                int status = addAddressVM.postalCodeValidation();

                if(status == Constants.POSTAL_CODE){

                    binding.addressInputPostal.setError("Enter Postal Code");
                    binding.addressInputPostal.requestFocus();

                }else if (status == Constants.SUCCESS)
                {
                    showProgressBar();

                    addAddressVM.LocateAddress();

                    addAddressVM.getSearchAddressVMMutableLiveData().observe(AddAddressActivity.this, new Observer<AddAddressVM>() {
                        @Override
                        public void onChanged(@Nullable AddAddressVM addAddressVM) {
                            hideProgressBar();

                            if(addAddressVM.msg.get().equalsIgnoreCase("success")) {

                                Toast.makeText(AddAddressActivity.this, "" + addAddressVM.msg.get(), Toast.LENGTH_SHORT).show();
                                addAddressVM.floor_unit_numer.set(addAddressVM.address_list.get().ADDRESS);
                                addAddressVM.address.set(addAddressVM.address_list.get().ADDRESS);
                                addAddressVM.city_name.set(String.valueOf(addAddressVM.city));
                            }else if(addAddressVM.msg.get().equalsIgnoreCase("error")){
                                Toast.makeText(AddAddressActivity.this, "" + addAddressVM.msg.get(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else
                {

                    Toast.makeText(AddAddressActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onShipaddressClicked() {
                binding.shippingCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            addAddressVM.is_shipping.set("1");

                        }else {
                            addAddressVM.is_shipping.set("0");
                        }
                    }
                });

            }

            @Override
            public void onBillAddressClicked() {

                binding.billingCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            addAddressVM.is_billing.set("1");

                        }else {
                            addAddressVM.is_billing.set("0");
                        }
                    }
                });

            }

            @Override
            public void onSaveClicked() {

                int status = addAddressVM.addressValidation();
                if (status == Constants.NAME_EMPTY)
                {
                    binding.addressInputName.setError("Enter name");
                    binding.addressInputName.requestFocus();

                } else if (status == Constants.CONTACT_NUMBER_EMPTY)
                {
                    binding.addressInputNumber.setError("Enter Contact Number");
                    binding.addressInputNumber.requestFocus();

                } else if (status == Constants.POSTAL_CODE)
                {
                    binding.addressInputPostal.setError("Enter Postal Code");
                    binding.addressInputPostal.requestFocus();

                } else if (status == Constants.ADDRESS)
                {
                    binding.addressInputUnitNo.setError("Enter Floor Number");
                    binding.addressInputUnitNo.requestFocus();

                }else if (status == Constants.ADDRESS1)
                {
                    binding.addressInputAddress.setError("required");
                    binding.addressInputAddress.requestFocus();

                }else if (status == Constants.CITY)
                {
                    binding.cityInputAddress.setError("Enter City");
                    binding.cityInputAddress.requestFocus();

                } else if (status == Constants.SUCCESS)
                {
                    showProgressBar();

                    addAddressVM.saveAddress(Session.getUserId(AddAddressActivity.this));

                    addAddressVM.getAddAddressVMMutableLiveData().observe(AddAddressActivity.this, new Observer<AddAddressVM>() {
                        @Override
                        public void onChanged(@Nullable AddAddressVM addAddressVM) {
                            hideProgressBar();

                            Toast.makeText(AddAddressActivity.this, ""+addAddressVM.msg.get(), Toast.LENGTH_SHORT).show();
                        }
                    });

                } else
                {

                    Toast.makeText(AddAddressActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onRadioButtonClicked() {

                binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int id = group.getCheckedRadioButtonId();
                        Log.e(TAG,"selected_id==>"+id);

                    }
                });

            }
        });
    }

    private void showProgressBar()
    {
        if (binding.registerProgress.getVisibility() == View.GONE)
            binding.registerProgress.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar()
    {
        if (binding.registerProgress.getVisibility() == View.VISIBLE)
            binding.registerProgress.setVisibility(View.GONE);
    }


}
