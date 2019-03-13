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

    @POST("users/login")
    Observable<POJOClass> loginApi(@Body LoginRequest loginRequest);

  /*  @FormUrlEncoded
    @POST("rguirh")
    Observable<POJOClass> forgotApi(@Field("forgot_name") String name);*/




  /*  @FormUrlEncoded
    @POST("Users/mobile_register")
    Observable<RegistrationPOJO> registerApi(
            @Field("first_name") String first_name,
            @Field("mobile") String mobile,
            @Field("email") String email,
            @Field("password") String password,
            @Field("login_type") String login_type,
            @Field("uid") String uid,
            @Field("device_id") String device_id,
            @Field("device_type") String device_type
    );*/
}
