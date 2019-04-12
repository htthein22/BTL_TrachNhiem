package com.htt22.btl_trachnhiem.LuatGiaoThong;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htt22.btl_trachnhiem.MainActivity;
import com.htt22.btl_trachnhiem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DuongThuy extends Fragment {


    public DuongThuy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(" Đường Thủy ");
        return inflater.inflate(R.layout.fragment_duong_thuy, container, false);
    }

}
