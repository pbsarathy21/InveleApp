package com.ninositsolution.inveleapp.forgot_password;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.view.View;

import com.ninositsolution.inveleapp.login.LoginVM;
import com.ninositsolution.inveleapp.pojo.POJOClass;
import com.ninositsolution.inveleapp.pojo.Users;

public class PasswordVM extends ViewModel{
    private PasswordRepo passwordRepo;

    public ObservableField<String> email = new ObservableField<>();

    private MutableLiveData<PasswordVM> passwordVMMutableLiveData = new MutableLiveData<>();

    public ObservableField<String> status = new ObservableField<>();
    public ObservableField<String> msg = new ObservableField<>();
    public ObservableField<Integer> otp = new ObservableField<>();
    public ObservableField<Integer> otp_verify = new ObservableField<>();
    public ObservableField<Users> users = new ObservableField<>();


    public PasswordVM( POJOClass pojoClass){

        this.status.set(pojoClass.status);
        this.msg.set(pojoClass.msg);
        this.otp.set(pojoClass.otp);
        this.otp_verify.set(pojoClass.otp_verify);
        this.users.set(pojoClass.users);

    }


    public PasswordVM()
    {
        passwordRepo = new PasswordRepo();

    }

    public int forgotPasswordEmailValidation(){

        return passwordRepo.forgotEmailValidation(email.get());
    }



    public MutableLiveData<PasswordVM> getPasswordVMMutableLiveData() {
        return passwordVMMutableLiveData;
    }

}


