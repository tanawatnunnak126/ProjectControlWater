package com.example.izecpeuru.antoapi;

import android.util.Log;

import com.example.izecpeuru.antoapi.Model.ResAntoObj;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AntoManager {

     private static final String BASE_URL = "https://api.anto.io/channel/";
     private static Retrofit retrofit;
     private AntoService antoService;
     private String KEY = "tvv2Tuzzq1EJd4YwJ8PS4gZwAjz84OYlngq6xdkI";
     private String THING = "Android_nodeMcu";
     private String dataReceive;
    AntoManager(){

    }
    public AntoManager(String key,String thing){
        this.KEY = key;
        this.THING = thing;

    }
     public void AntoReceive(final AntoCallBackListiner antoCallBackListiner, String chanel){
         antoService = ApiAnto.getApi();
         Log.i("Anto","Create ApiAnto");
         Call call = antoService.getAnto(KEY,THING,chanel);
           call.enqueue(new Callback<ResAntoObj>() {
               @Override
               public void onResponse(Call<ResAntoObj> call, Response<ResAntoObj> response) {
                   ResAntoObj resAntoObj = response.body();
                   if(resAntoObj==null){
                       ResponseBody responseBody = response.errorBody();
                       if (responseBody != null) {
                           antoCallBackListiner.onBodyError(responseBody);
                       } else {
                           antoCallBackListiner.onBodyErrorIsNull();
                       }
                   } else {
                       antoCallBackListiner.onResponse(resAntoObj);
                   }

               }

               @Override
               public void onFailure(Call<ResAntoObj> call, Throwable t) {
                    antoCallBackListiner.onFailure(t);
               }
           });

     }
    private static class ApiAnto{
         private static AntoService getApi(){
             if(retrofit == null){
                 retrofit = new Retrofit.Builder()
                         .baseUrl(BASE_URL)
                         .addConverterFactory(GsonConverterFactory.create())
                         //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                         .build();
             }
             return retrofit.create(AntoService.class);
         }

    }





}
