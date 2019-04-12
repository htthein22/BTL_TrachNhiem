package com.htt22.btl_trachnhiem;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.htt22.btl_trachnhiem.CauHoi.DBAdapter;
import com.htt22.btl_trachnhiem.LuatGiaoThong.DuongBo;
import com.htt22.btl_trachnhiem.LuatGiaoThong.DuongHangKhong;
import com.htt22.btl_trachnhiem.LuatGiaoThong.DuongSat;
import com.htt22.btl_trachnhiem.LuatGiaoThong.DuongThuy;
import com.htt22.btl_trachnhiem.LuatGiaoThong.TrangChu;
import java.io.IOException;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fb,zalo,mess;
    Boolean hideShow = false;
    RelativeLayout rlt;
    AlertDialog alertDialog;
    Context context;
    private long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rlt=findViewById(R.id.rlt);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            android.view.Window window = getWindow();
            int my = Color.rgb(76, 175, 80);
            window.setStatusBarColor(my);
        }



        TrangChu trangChu = new TrangChu();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main,trangChu,trangChu.getTag()).commit();

        DBAdapter dbAdapter = new DBAdapter(this);
        try {
            dbAdapter.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fb = (FloatingActionButton) findViewById(R.id.fb);
        zalo = (FloatingActionButton) findViewById(R.id.zalo);
        mess = (FloatingActionButton) findViewById(R.id.mess);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fb = new Intent(Intent.ACTION_SEND);
                fb.setType("text/plain");
                startActivity(Intent.createChooser(fb, "Chọn một ứng dụng :"));
            }
        });
        zalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fb = new Intent(Intent.ACTION_SEND);
                fb.setType("message/rfc822");
                startActivity(Intent.createChooser(fb, "Chọn một ứng dụng :"));
            }
        });
        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mess = new Intent(Intent.ACTION_SEND);
                mess.setType("text/plain");
                startActivity(Intent.createChooser(mess, "Chọn một ứng dụng :"));
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hideShow == false){
                    showFab();
                    hideShow = true;
                }else {
                    hideFab();
                    hideShow = false;
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void showFab(){
        fb.show();
        zalo.show();
        mess.show();
    }
    public  void hideFab(){
        fb.hide();
        zalo.hide();
        mess.hide();
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (time + 2000 > System.currentTimeMillis()){
                super.onBackPressed();
                return;
            }else {
                Toast.makeText(getBaseContext(), "Chạm lần nữa để thoát!", Toast.LENGTH_SHORT).show();
            }
            time = System.currentTimeMillis();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.trangchu) {
            TrangChu trangChu = new TrangChu();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,trangChu,trangChu.getTag()).commit();
//            rlt.setVisibility(View.GONE);

        }else if (id == R.id.duongbo){
            DuongBo duongBo = new DuongBo();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,duongBo,duongBo.getTag()).commit();
        }
        else if (id == R.id.duongthuy){
            DuongThuy duongThuy = new DuongThuy();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,duongThuy,duongThuy.getTag()).commit();
        }
        else if (id == R.id.duongsat){
            DuongSat duongSat = new DuongSat();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,duongSat,duongSat.getTag()).commit();
        }
        else if (id == R.id.duonghangkhong){
            DuongHangKhong duongHangKhong = new DuongHangKhong();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main,duongHangKhong,duongHangKhong.getTag()).commit();

        }
        else if (id == R.id.thoat){
            thoat();

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void thoat(){
        AlertDialog.Builder thongbao = new AlertDialog.Builder(
                MainActivity.this);


//        thongbao.setTitle("Thoát");

        thongbao
                .setTitle("Bạn có muốn thoát ?")
                .setCancelable(false)
                .setPositiveButton("Có",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Không",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = thongbao.create();
        alertDialog.show();
    }

}
