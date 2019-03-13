package com.ninositsolution.inveleapp.api;

import com.ninositsolution.inveleapp.login.LoginRequest;
import com.ninositsolution.inveleapp.pojo.POJOClass;
import com.ninositsolution.inveleapp.registration.pojo.RegistartionRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("users/mobile_register")
    Observable<POJOClass> registerApi(@Body RegistartionRequest registartionRequest);

    @FormUrlEncoded
    @POST("users/forgot_password")
    Observable<POJOClass> forgotPasswordApi (@Field("forgot_name")String forgotName);

    @POST("users/login")
    Observable<POJOClass> loginApi(@Body LoginRequest loginRequest);

}
