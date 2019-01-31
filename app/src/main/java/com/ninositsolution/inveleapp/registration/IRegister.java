package com.ninositsolution.inveleapp.registration;

/**
 * Created by Parthasarathy D on 1/12/2019.
 * Ninos IT Solution
 * parthasarathy.d@ninositsolution.com
 */
public interface IRegister {

    void onEmailLayoutClicked();
    void onMobileLayoutClicked();
    void onEmailContinueClicked();
    void onOtpContinueClicked();
    void onMobileContinueClicked();
    void updateTimer(String time);
    void onResendClicked();
    void onUserClicked();
    void onUser2Clicked();
}
