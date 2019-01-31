package com.ninositsolution.inveleapp.registration;

import android.support.annotation.NonNull;
import android.util.Patterns;

/**
 * Created by Parthasarathy D on 1/11/2019.
 * Ninos IT Solution
 * parthasarathy.d@ninositsolution.com
 */
public class RegisterModel {

    @NonNull
    private String email;

    @NonNull
    private String name;

    @NonNull
    private String mobile;

    @NonNull
    private String password;

    @NonNull
    private String otp;

    @NonNull
    private String confirmPassword;

    public RegisterModel() {
    }

    public RegisterModel(@NonNull String email, @NonNull String name, @NonNull String mobile, @NonNull String password, @NonNull String otp, @NonNull String confirmPassword) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.otp = otp;
        this.confirmPassword = confirmPassword;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getMobile() {
        return mobile;
    }

    public void setMobile(@NonNull String mobile) {
        this.mobile = mobile;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getOtp() {
        return otp;
    }

    public void setOtp(@NonNull String otp) {
        this.otp = otp;
    }

    @NonNull
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NonNull String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int EmailLayoutValidation()
    {
        if (getEmail().isEmpty())
        {
            return 1;
        }

        if (getName().isEmpty())
        {
            return 2;
        }

        if (getPassword().isEmpty())
        {
            return 3;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
        {
            return 4;
        }

        if (getPassword().length()>3)
        {
            return 5;
        }

        return 0;
    }

    public int MobileLayoutValidation()
    {
        if (getName().isEmpty())
        {
            return 1;
        }
        return 0;
    }

    public int OtpLayoutValidation()
    {
        if (getOtp().isEmpty())
        {
            return 1;
        }
        return 0;
    }
}
