package com.ninositsolution.inveleapp.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.ninositsolution.inveleapp.pojo.POJOClass;
import com.ninositsolution.inveleapp.pojo.Users;

public class LoginVM extends ViewModel {

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    private MutableLiveData<LoginVM> loginVMMutableLiveData = new MutableLiveData<>();

    public ObservableField<String> status = new ObservableField<>();
    public ObservableField<String> msg = new ObservableField<>();
    public ObservableField<Integer> otp = new ObservableField<>();
    public ObservableField<Integer> otp_verify = new ObservableField<>();
    public ObservableField<Users> users = new ObservableField<>();

    public LoginVM(POJOClass pojoClass)
    {
        this.status.set(pojoClass.status);
        this.msg.set(pojoClass.msg);
        this.otp.set(pojoClass.otp);
        this.otp_verify.set(pojoClass.otp_verify);
        this.users.set(pojoClass.users);
    }

    public MutableLiveData<LoginVM> getLoginVMMutableLiveData() {
        return loginVMMutableLiveData;
    }
}
