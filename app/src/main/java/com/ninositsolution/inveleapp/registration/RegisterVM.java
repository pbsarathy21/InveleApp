package com.ninositsolution.inveleapp.registration;

import android.content.Context;
import android.databinding.BaseObservable;
import android.os.CountDownTimer;

/**
 * Created by Parthasarathy D on 1/11/2019.
 * Ninos IT Solution
 * parthasarathy.d@ninositsolution.com
 */
public class RegisterVM extends BaseObservable {

    //Declarations

 /*   private RegisterModel registerModel;
    private Context context;
    private IRegister iRegister;

    //Constructors

    public RegisterVM(Context context, IRegister iRegister ) {
        this.context = context;
        this.iRegister = iRegister;
        registerModel = new RegisterModel();
    }

    //Edit text Listeners

    public void afterEmailChanged(CharSequence sequence)
    {
        registerModel.setEmail(sequence.toString());
    }

    public void afterNameChanged(CharSequence sequence)
    {
        registerModel.setName(sequence.toString());
    }

    public void afterPasswordChanged(CharSequence sequence)
    {
        registerModel.setPassword(sequence.toString());
    }

    public void afterMobile2Changed(CharSequence sequence)
    {
        registerModel.setMobile(sequence.toString());
    }

    public void afterOtpChanged(CharSequence sequence)
    {
        registerModel.setOtp(sequence.toString());
    }

    //onClick Listeners

    public void onEmailClicked()
    {
          iRegister.onEmailLayoutClicked();
    }

    public void onMobileClicked()
    {
       iRegister.onMobileLayoutClicked();
    }

    public void onResendClicked()
    {
        RunTimer();
        iRegister.onResendClicked();
    }

    public void onUserClicked()
    {
        iRegister.onUserClicked();
    }

    public void onEmailContinueClicked()
    {
        iRegister.onEmailContinueClicked();
        RunTimer();
    }

    public void onOtpContinueClicked()
    {

    }

    public void onUser2Clicked()
    {
        iRegister.onUser2Clicked();
    }

    public void onMobileContinueClicked()
    {

        RunTimer();
    }

    public void onFacebookClicked()
    {

    }

    public void onGoogleClicked()
    {

    }

    //background process

    private void RunTimer()
    {
        final int[] time = {45};

        new CountDownTimer(45000, 1000)
        {
            public void onTick(long millisUntilFinished) {
                iRegister.updateTimer(millisUntilFinished/1000+ " Sec");
                time[0]--;
            }

            public void onFinish() {
                iRegister.updateTimer("Try Again");
            }

        }.start();

    }
*/
}