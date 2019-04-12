package com.htt22.btl_trachnhiem.LuatGiaoThong;

import android.view.View;

public class DeThi {
    private String name;

    public DeThi(String name) {
        this.name = name;
    }
    public DeThi(){

    }
    public interface ItemClickListener {
        void onClick(View view, int position);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
