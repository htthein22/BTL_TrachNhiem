package com.htt22.btl_trachnhiem.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.htt22.btl_trachnhiem.CauHoi.CauHoi;
import com.htt22.btl_trachnhiem.CauHoi.DieuKhien;
import com.htt22.btl_trachnhiem.LuatGiaoThong.DuongBo;
import com.htt22.btl_trachnhiem.MainActivity;
import com.htt22.btl_trachnhiem.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ViewHome extends FragmentActivity {

    private static final int NUM_PAGES = 20;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    DieuKhien dieuKhien;
    ArrayList<CauHoi> cauHoiArrayList;
    TextView tvTime;
    CounterClass time;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_home);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        //thoi gian
        tvTime=findViewById(R.id.tvtime);
        time = new CounterClass(300*1000,1000);
        time.start();

        android.view.Window window = getWindow();
        int my = Color.rgb(76, 175, 80);
        window.setStatusBarColor(my);

        dieuKhien = new DieuKhien(this);
        cauHoiArrayList = new ArrayList<CauHoi>();
        cauHoiArrayList = dieuKhien.getcauHoi(1,"duongbo");

    }
    public void previous(View view){
        AlertDialog.Builder thongbao = new AlertDialog.Builder(
                ViewHome.this);
        thongbao
                .setTitle("Kết thúc bài thi ?")
                .setCancelable(false)
                .setPositiveButton("Có",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        startActivity(new Intent(ViewHome.this, MainActivity.class));
                    }
                })
                .setNegativeButton("Không",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = thongbao.create();
        alertDialog.show();

    }

    public ArrayList<CauHoi> getData(){

        return cauHoiArrayList;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ViewHomeFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTime.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            startActivity(new Intent(ViewHome.this, MainActivity.class));
            Toast.makeText(ViewHome.this, "Hết thời gian làm bài!", Toast.LENGTH_SHORT).show();
        }
    }
}
