package com.htt22.btl_trachnhiem.CauHoi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DieuKhien {
    private DBAdapter dbAdapter;

    public DieuKhien(Context context) {
        dbAdapter = new DBAdapter(context);
    }

    public ArrayList<CauHoi> getcauHoi(int sode, String monhoc){
        ArrayList<CauHoi> cauHoiArrayList = new ArrayList<CauHoi>();
        SQLiteDatabase db = dbAdapter.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cauhoi WHERE sode = '"+sode+"' AND monhoc = '"+monhoc+"'",null);
        cursor.moveToFirst();
        do {
            CauHoi item;
            item = new CauHoi(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),
                    cursor.getString(6),cursor.getString(7),cursor.getInt(8),cursor.getString(9));
            cauHoiArrayList.add(item);
        }while (cursor.moveToNext());
        return cauHoiArrayList;
    }
}
