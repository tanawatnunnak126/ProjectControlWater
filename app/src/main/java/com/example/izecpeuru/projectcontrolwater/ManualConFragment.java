package com.example.izecpeuru.projectcontrolwater;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManualConFragment extends Fragment {

    public static ManualConFragment newInstance() {

        Bundle args = new Bundle();

        ManualConFragment fragment = new ManualConFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public ManualConFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_manual_control, container, false);
        return rootView;
    }

}
