package com.example.izecpeuru.projectcontrolwater;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AutoConFragment extends Fragment {

    public static AutoConFragment newInstance() {

        Bundle args = new Bundle();

        AutoConFragment fragment = new AutoConFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public AutoConFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auto_control, container, false);
    }

}
