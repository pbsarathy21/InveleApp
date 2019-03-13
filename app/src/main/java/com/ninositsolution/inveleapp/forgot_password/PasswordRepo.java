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


    public MutableLiveData<PasswordVM> getPasswordVMMutableLiveData(String email) {


        ApiService apiService = RetrofitClient.getApiService();

        apiService.forgotPasswordApi(email).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<POJOClass>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(POJOClass pojoClass) {

                        Log.i(TAG, "onNext : "+pojoClass.status);

                        PasswordVM passwordVM = new PasswordVM(pojoClass);

                        passwordVMMutableLiveData.setValue(passwordVM);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError : "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return passwordVMMutableLiveData;
    }

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
