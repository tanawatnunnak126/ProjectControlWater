package com.example.izecpeuru.antoapi;

import android.text.GetChars;

import com.example.izecpeuru.antoapi.Model.ResAntoObj;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AntoService {
    @GET("get/{key}/{thing}/{chanel}")
    Call<ResAntoObj> getAnto(@Path("key")String key,
                             @Path("thing")String thing,
                             @Path("chanel")String chanel);

    @GET("set/{key}/{thing}/{chanel}/{value}")
    Observable<ResAntoObj> setAnto(@Path("key")String key,
                                   @Path("thing")String thing,
                                   @Path("chanel")String chanel,
                                   @Path("value")String value);
}
