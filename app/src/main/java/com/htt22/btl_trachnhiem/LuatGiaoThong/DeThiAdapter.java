package com.htt22.btl_trachnhiem.LuatGiaoThong;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.htt22.btl_trachnhiem.R;
import com.htt22.btl_trachnhiem.ViewPager.ViewHome;

import java.util.List;

public class DeThiAdapter extends RecyclerView.Adapter<DeThiAdapter.ViewHolder>{

    private Context context;
    private List<DeThi> deThiList;

    public DeThiAdapter(Context context, List<DeThi> deThiList){
        this.context = context;
        this.deThiList = deThiList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeView) {
        View view = LayoutInflater.from(context).inflate(R.layout.dethi,null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final DeThi deThi = deThiList.get(position);
//        final Te vt = viewHolder.getAdapterPosition();


        viewHolder.tvdethi.setText(deThi.getName());
        viewHolder.imgdethi.setImageResource(R.drawable.made);

        //ấn vào item recyclerview
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chon(position);
//                Toast.makeText(context, ""+deThi.getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void chon(int position){
        AlertDialog.Builder thongbao = new AlertDialog.Builder(context);
        final DeThi deThi = deThiList.get(position);
        thongbao
                .setTitle("Bắt đầu thi "+deThi.getName()+"?")
                .setCancelable(false)
                .setPositiveButton("Có",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Intent i = new Intent(context, ViewHome.class);
                        context.startActivity(i);
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


    @Override
    public int getItemCount() {
        return deThiList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvdethi;
        ImageView imgdethi;
        public ViewHolder( View itemView) {
            super(itemView);
            tvdethi=itemView.findViewById(R.id.name);
            imgdethi=itemView.findViewById(R.id.anh);

        }
    }

}
