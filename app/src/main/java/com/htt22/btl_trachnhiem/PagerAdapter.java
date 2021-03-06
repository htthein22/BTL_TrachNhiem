package com.htt22.btl_trachnhiem;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void add(Fragment fragment,String title){
        fragmentList.add(fragment);
        titleList.add(title);
    }


    @Override
    public Fragment getItem(int posotion) {
        return fragmentList.get(posotion);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
