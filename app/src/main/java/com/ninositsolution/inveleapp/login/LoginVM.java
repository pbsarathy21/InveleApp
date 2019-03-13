package com.ninositsolution.inveleapp.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.ninositsolution.inveleapp.pojo.POJOClass;
import com.ninositsolution.inveleapp.pojo.Users;

public class LoginVM extends ViewModel {

    private LoginRepo loginRepo;

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    private MutableLiveData<LoginVM> loginVMMutableLiveData = new MutableLiveData<>();

    public ObservableField<String> status = new ObservableField<>();
    public ObservableField<String> msg = new ObservableField<>();
    public ObservableField<Integer> otp = new ObservableField<>();
    public ObservableField<Integer> otp_verify = new ObservableField<>();
    public ObservableField<Users> user = new ObservableField<>();

    public LoginVM(POJOClass pojoClass)
    {
        this.status.set(pojoClass.status);
        this.msg.set(pojoClass.msg);
        this.otp.set(pojoClass.otp);
        this.otp_verify.set(pojoClass.otp_verify);
        this.user.set(pojoClass.user);
    }

    public LoginVM()
    {
        loginRepo = new LoginRepo();
    }

    public void loginViaEmail()
    {
        LoginRequest loginRequest = new LoginRequest(username.get(), password.get());
        loginVMMutableLiveData = loginRepo.getLoginVMMutableLiveData(loginRequest);
    }

   public Integer emailValidations()
   {
       return loginRepo.emailValidations(username.get(), password.get());
   }

  /* public Integer mobileValidations()
   {
       //return loginRepo.mobileValidations();
   }*/

    public MutableLiveData<LoginVM> getLoginVMMutableLiveData() {
        return loginVMMutableLiveData;
    }
}
