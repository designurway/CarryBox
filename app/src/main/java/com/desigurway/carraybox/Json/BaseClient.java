package com.desigurway.carraybox.Json;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseClient {
    final static String BaseUrl = "http://192.168.4.178/CarryBoxUserApi/";
    private static Retrofit retrofitEndPoint = null;

    public static Retrofit getBaseClient(){
        if (retrofitEndPoint==null){
            retrofitEndPoint = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitEndPoint;
    }
}
