package com.ninositsolution.inveleapp.login;

import android.content.Context;
import android.databinding.BaseObservable;

import com.ninositsolution.inveleapp.registration.RegisterModel;

public class LoginVM extends BaseObservable {

    //Declarations

    private RegisterModel registerModel;
    private Context context;
    private ILogin iLogin;

    //constructors


    public LoginVM(Context context, ILogin iLogin) {
        this.context = context;
        this.iLogin = iLogin;
        registerModel = new RegisterModel();
    }

    //Edit text Listeners

    public void afterEmailChanged(CharSequence sequence)
    {

    }

    public void afterPasswordChanged(CharSequence sequence)
    {

    }

    public void afterPhoneChanged(CharSequence sequence)
    {

    }

    public void afterSMSChanged(CharSequence sequence)
    {

    }

   //OnClick Listeners

    public void onForgotClicked()
    {
        iLogin.onForgotClicked();
    }

    public void onLoginEmailClicked()
    {
        iLogin.onLoginEmailClicked();
    }

    public void onResendCodeClicked()
    {
        iLogin.onResendCodeClicked();
    }

    public void onLoginPhoneClicked()
    {
        iLogin.onLoginPhoneClicked();
    }

    public void onNewUserClicked()
    {
        iLogin.onNewUserClicked();
    }

    public void onLoginWithClicked()
    {
        iLogin.onLoginWithClicked();
    }

    public void onFacebookClicked()
    {
        iLogin.onFacebookClicked();
    }

    public void onGoogleClicked()
    {
        iLogin.onGoogleClicked();
    }



}
