package com.htt22.btl_trachnhiem.LuatGiaoThong;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htt22.btl_trachnhiem.MainActivity;
import com.htt22.btl_trachnhiem.PagerAdapter;
import com.htt22.btl_trachnhiem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChu extends Fragment {
    TabLayout tab;
    ViewPager viewpg;
    PagerAdapter pagerAdapter;

    public TrangChu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(" Trang Chủ ");
        View view= inflater.inflate(R.layout.fragment_trang_chu,container,false);
        tab = view.findViewById(R.id.tab);
        viewpg = view.findViewById(R.id.view);
        setTabView();
        return view;
    }
    public void setTabView(){
        pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager());
        pagerAdapter.add(new DuongBo(),"Đường Bộ");
        pagerAdapter.add(new DuongSat(),"Đường Sắt");
        pagerAdapter.add(new DuongThuy(),"Đường Thủy");
        pagerAdapter.add(new DuongHangKhong(),"Đường Hàng Không");
        viewpg.setAdapter(pagerAdapter);
        tab.setupWithViewPager(viewpg);
        viewpg.setOffscreenPageLimit(4);
    }

}
