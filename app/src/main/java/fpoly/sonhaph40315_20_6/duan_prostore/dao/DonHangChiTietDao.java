package fpoly.sonhaph40315_20_6.duan_prostore.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.database.DonHangChiTietHelper;
import fpoly.sonhaph40315_20_6.duan_prostore.model.DonHangChiTiet;

public class DonHangChiTietDao {
    private final SQLiteDatabase db;

    public DonHangChiTietDao(Context context) {
        DonHangChiTietHelper helper = new DonHangChiTietHelper(context);
        db = helper.getWritableDatabase();
    }

    public long insert(DonHangChiTiet chiTiet) {
        ContentValues values = new ContentValues();
        values.put("orderId", chiTiet.getOrderId());
        values.put("productId", chiTiet.getProductId());
        values.put("soLuong", chiTiet.getSoLuong());
        values.put("giaTien", chiTiet.getGiaTien());
        values.put("username", chiTiet.getUsername());
        return db.insert("DonHangChiTiet", null, values);
    }

    public List<DonHangChiTiet> getByOrderId(int orderId) {
        List<DonHangChiTiet> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM DonHangChiTiet WHERE orderId = ?", new String[]{String.valueOf(orderId)});
        if (cursor.moveToFirst()) {
            do {
                DonHangChiTiet chiTiet = new DonHangChiTiet();
                chiTiet.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                chiTiet.setOrderId(cursor.getInt(cursor.getColumnIndexOrThrow("orderId")));
                chiTiet.setProductId(cursor.getInt(cursor.getColumnIndexOrThrow("productId")));
                chiTiet.setSoLuong(cursor.getInt(cursor.getColumnIndexOrThrow("soLuong")));
                chiTiet.setGiaTien(cursor.getDouble(cursor.getColumnIndexOrThrow("giaTien")));
                chiTiet.setUsername(cursor.getString(cursor.getColumnIndexOrThrow("username")));
                list.add(chiTiet);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
}
