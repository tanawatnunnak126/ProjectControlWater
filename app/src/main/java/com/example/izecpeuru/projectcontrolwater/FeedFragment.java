package com.example.izecpeuru.projectcontrolwater;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.izecpeuru.antoapi.AntoManager;
import com.example.izecpeuru.antoapi.AntoCallBackListiner;
import com.example.izecpeuru.antoapi.AntoService;
import com.example.izecpeuru.antoapi.Model.ResAntoObj;

import java.util.Timer;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    private static String BASE_URL = "https://api.anto.io/channel/";
    private static Retrofit retrofit;
    private AntoService antoService;
    private String KEY = "vWiQqQBceJTDHnr9q407lb9IgeJwy85Hxd2Lpt4Y";
    private String THING = "Android_nodeMcu";
    String datatest;

    Timer timer;
    private View rootView;
    private TextView tv_pump1;
    private TextView tv_pump2;
    private TextView tv_lv_water;

    public static FeedFragment newInstance() {

        FeedFragment fragment = new FeedFragment();
        Bundle bundle = new Bundle();
        //bundle.putString("");
        fragment.setArguments(bundle);
        return fragment;
    }

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Check", "onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Check", "onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
        Log.i("Check", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Check", "onStop");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_monitor, container, false);
        initInstance();
        callAnto();
        xxx
        return rootView;
    }

    AntoCallBackListiner antoCallBackListiner = new AntoCallBackListiner() {
        @Override
        public void onResponse(ResAntoObj resAntoObj) {
            Log.d("abc", "onResponse: " + resAntoObj.getValue());

        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {

        }

        @Override
        public void onBodyErrorIsNull() {

        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    private void initInstance() {
        tv_pump1 = rootView.findViewById(R.id.tv_pump1);
        tv_pump2 = rootView.findViewById(R.id.tv_pump2);
    }

    private void callAnto() {
        AntoManager anto = new AntoManager(KEY,THING);
        anto.AntoReceive(antoCallBackListiner,"pump1");
    }

}
