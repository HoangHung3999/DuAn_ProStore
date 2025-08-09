package fpoly.sonhaph40315_20_6.duan_prostore.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.database.GioHang_Database;
import fpoly.sonhaph40315_20_6.duan_prostore.model.DonHang_Model;

public class DonHang_Dao {
    private final SQLiteDatabase db;

    public DonHang_Dao(Context context) {
        GioHang_Database donHang_database = new GioHang_Database(context);
        db = donHang_database.getWritableDatabase();
    }

    public void add_DonHang(DonHang_Model donhang) {
        String name = donhang.getName().trim().toLowerCase();
        String size = donhang.getSize().trim().toLowerCase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM DonHang WHERE LOWER(TRIM(name)) = ? AND LOWER(TRIM(size)) = ?",
                new String[]{name, size}
        );

        if (cursor.moveToFirst()) {
            int currentQuantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));
            int newQuantity = currentQuantity + donhang.getQuantity();

            ContentValues values = new ContentValues();
            values.put("quantity", newQuantity);
            db.update("DonHang", values, "LOWER(TRIM(name)) = ? AND LOWER(TRIM(size)) = ?", new String[]{name, size});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("imageresid", donhang.getImageresid());
            contentValues.put("name", donhang.getName());
            contentValues.put("price", donhang.getPrice());
            contentValues.put("size", donhang.getSize());
            contentValues.put("quantity", donhang.getQuantity());
            contentValues.put("status", donhang.getStatus());
            db.insert("DonHang", null, contentValues);
        }
        cursor.close();
    }
    public ArrayList<DonHang_Model> getDonHangChoXacNhan() {
        ArrayList<DonHang_Model> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM DonHang WHERE status = ?", new String[]{"Chờ xác nhận"});
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                int imageresid = cursor.getInt(cursor.getColumnIndexOrThrow("imageresid"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
                String size = cursor.getString(cursor.getColumnIndexOrThrow("size"));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));
                String status = cursor.getString(cursor.getColumnIndexOrThrow("status"));
                DonHang_Model donHang_model = new DonHang_Model(id,imageresid, name, price, size, quantity, status);
                list.add(donHang_model);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void clearAll() {
        db.delete("DonHang", null, null);
    }

    public void updateStatus(String name, String size, String newStatus) {
        ContentValues values = new ContentValues();
        values.put("status", newStatus);
        db.update("DonHang", values, "name = ? AND size = ?", new String[]{name, size});
    }
    public long insertDonHang(DonHang_Model donHang) {
        ContentValues values = new ContentValues();
        values.put("imageresid", donHang.getImageresid());
        values.put("name", donHang.getName());
        values.put("price", donHang.getPrice());
        values.put("size", donHang.getSize());
        values.put("quantity", donHang.getQuantity());
        values.put("status", donHang.getStatus());
        return db.insert("DonHang", null, values);
    }


}