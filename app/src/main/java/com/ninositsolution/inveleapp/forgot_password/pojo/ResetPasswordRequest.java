package com.ninositsolution.inveleapp.forgot_password.pojo;

public class ResetPasswordRequest {

    public Integer id;
    public String password;
    public String password_confirmation;


    public ResetPasswordRequest(Integer id, String password,String password_confirmation){
        this.id = id;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }

}
