package com.ninositsolution.inveleapp.forgot_password;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import android.util.Patterns;

import com.ninositsolution.inveleapp.api.ApiService;
import com.ninositsolution.inveleapp.api.RetrofitClient;
import com.ninositsolution.inveleapp.pojo.POJOClass;
import com.ninositsolution.inveleapp.registration.RegisterVM;
import com.ninositsolution.inveleapp.registration.pojo.RegistartionRequest;
import com.ninositsolution.inveleapp.utils.Constants;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PasswordRepo {

    private static final String TAG = "PasswordRepo";
    private MutableLiveData<PasswordVM> passwordVMMutableLiveData = new MutableLiveData<>();


    public int forgotEmailValidation(String forgotemail) {
        if (forgotemail.isEmpty())
        {
            return Constants.EMAIL_EMPTY;
        } else
            {

            return Constants.SUCCESS;
        }
    }
}
