package com.ninositsolution.inveleapp.address_book;

import android.content.Context;

/**
 * Created by Parthasarathy D on 1/25/2019.
 * Ninos IT Solution Pvt Ltd
 * ben@ninositsolution.com
 */
public class AddressBookVM {

    private AddressBookModel addressBookModel;
    private Context context;
    private IAddressBook iAddressBook;

    public AddressBookVM(Context context, IAddressBook iAddressBook) {
        this.context = context;
        this.iAddressBook = iAddressBook;
    }

    //ClickListeners

    public void onAddAddressClicked()
    {
        iAddressBook.onAddAddressClicked();
    }
    public void onBackClicked()
    {
        iAddressBook.onBackClicked();
    }
    public void onEditClicked()
    {
        iAddressBook.onEditClicked();
    }

}
