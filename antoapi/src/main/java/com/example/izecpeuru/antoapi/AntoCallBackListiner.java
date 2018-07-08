package com.example.izecpeuru.antoapi;

import com.example.izecpeuru.antoapi.Model.ResAntoObj;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public interface AntoCallBackListiner {
    public void onResponse(ResAntoObj resAntoObj);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
