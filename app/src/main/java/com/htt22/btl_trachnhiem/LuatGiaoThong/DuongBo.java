package com.htt22.btl_trachnhiem.LuatGiaoThong;


import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.htt22.btl_trachnhiem.MainActivity;
import com.htt22.btl_trachnhiem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DuongBo extends Fragment {

    RecyclerView rvdethi;
    List<DeThi> deThiList = new ArrayList<>();
    DeThiAdapter deThiAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(" Đường Bộ ");

        return inflater.inflate(R.layout.fragment_duong_bo, container, false);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvdethi= getActivity().findViewById(R.id.dsdethi);

        RecyclerView.LayoutManager  layoutManager= new GridLayoutManager(getContext(),2);

//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        rvdethi.setLayoutManager(layoutManager);
        deThiAdapter = new DeThiAdapter(getContext(),deThiList);

        DeThi deThi = new DeThi("Đề số 1");
        DeThi deThi2 = new DeThi("Đề số 2");
        DeThi deThi3 = new DeThi("Đề số 3");
        DeThi deThi4 = new DeThi("Đề số 4");
        DeThi deThi5 = new DeThi("Đề số 5");
        DeThi deThi6 = new DeThi("Đề số 6");
        deThiList.add(deThi);
        deThiList.add(deThi2);
        deThiList.add(deThi3);
        deThiList.add(deThi4);
        deThiList.add(deThi5);
        deThiList.add(deThi6);
        rvdethi.setAdapter(deThiAdapter);
        deThiAdapter.notifyDataSetChanged();

        //tablayout
//        TabLayout tabLayout = new TabLayout(getActivity());
//        tabLayout=getActivity().findViewById(R.id.tab);
//        tabLayout.addTab(tabLayout.newTab().setText("hihi"));
//        tabLayout.addTab(tabLayout.newTab().setText("hihi"));
//        tabLayout.addTab(tabLayout.newTab().setText("hihi"));






//        btn=getActivity().findViewById(R.id.go);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getActivity(), ViewHome.class);
//                startActivity(i);
//            }
//        });
    }



}
