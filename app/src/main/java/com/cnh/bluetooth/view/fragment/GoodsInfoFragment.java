package com.cnh.bluetooth.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnh.bluetooth.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsInfoFragment extends Fragment {


    public GoodsInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_info, container, false);
    }

}
