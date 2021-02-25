package com.desigurway.carraybox.Json;

import com.desigurway.carraybox.Json.auth.SaveMobileData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CarryBoxApi {

    @FormUrlEncoded
    @POST("save_user_mobile.php")
    Call<SaveMobileData> saveUserMobile(
            @Field("phone") String phone
    );


    @FormUrlEncoded
    @POST("user_register.php")
    Call<SaveMobileData> registerMobile(
            @Field("mobile") String mobile
    );
}
