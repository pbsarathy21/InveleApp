package com.ninositsolution.inveleapp.add_address;

import android.content.Context;

public class AddAddressVM {

    private AddAddressModel addAddressModel;
    private Context context;
    private IAddAddress iAddAddress;

    public AddAddressVM(Context context, IAddAddress iAddAddress) {
        this.context = context;
        this.iAddAddress = iAddAddress;
    }

    //ClickListeners

    public void onBackClicked()
    {
        iAddAddress.onBackClicked();
    }
}
