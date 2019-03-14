package com.ninositsolution.inveleapp.api;

import com.ninositsolution.inveleapp.forgot_password.pojo.ResetPasswordRequest;
import com.ninositsolution.inveleapp.login.LoginRequest;
import com.ninositsolution.inveleapp.add_address.pojo.AddAddressRequest;
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

    @POST("users/address/add")
    Observable<POJOClass> addAddressApi(@Body AddAddressRequest addAddressRequest);

    @POST("postal-code-search")
    Observable<POJOClass> locateAddressApi(@Body AddAddressRequest addAddressRequest);


    @FormUrlEncoded
    @POST("users/forgot_password")
    Observable<POJOClass> forgotPasswordApi (@Field("forgot_name")String forgotName);

    @POST("users/reset_password")
    Observable<POJOClass> resetPasswordApi (@Body ResetPasswordRequest resetPasswordRequest);



    @POST("users/login")
    Observable<POJOClass> loginApi(@Body LoginRequest loginRequest);

    @FormUrlEncoded
    @POST("users/otp_verify")
    Observable<POJOClass> otpVerifyApi(@Field("user_id") String user_id,
                                       @Field("otp") String otp);
}
