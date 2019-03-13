package com.ninositsolution.inveleapp.forgot_password;

import android.content.Context;
import android.databinding.BaseObservable;

public class PasswordVM extends BaseObservable {

    //Declarations

    //private RegisterModel registerModel;
    private Context context;
    private IPassword iPassword;

    //constructors


    public PasswordVM(Context context, IPassword iPassword) {
        this.context = context;
        this.iPassword = iPassword;
        //registerModel = new RegisterModel();
    }

    //Edit text Listeners

    public void afterEmailPhoneChanged(CharSequence sequence)
    {

    }

    public void afterPasswordChanged(CharSequence sequence)
    {

    }

    public void afterConfirmPasswordChanged(CharSequence sequence)
    {

    }

    //OnClick Listeners

    public void onResetClicked()
    {
        iPassword.onResetClicked();
    }

    public void onSubmitClicked()
    {
        iPassword.onSubmitClicked();
    }

    public void onBackClicked()
    {
        iPassword.onBackClicked();
    }
}
