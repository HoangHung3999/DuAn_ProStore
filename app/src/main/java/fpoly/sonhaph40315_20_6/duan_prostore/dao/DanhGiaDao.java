package fpoly.sonhaph40315_20_6.duan_prostore.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.database.DanhGiaHelper;
import fpoly.sonhaph40315_20_6.duan_prostore.model.DanhGia;

public class DanhGiaDao {
    private final DanhGiaHelper dbHelper;

    public DanhGiaDao(Context context) {
        dbHelper = new DanhGiaHelper(context);
    }

    public List<DanhGia> getAll() {
        List<DanhGia> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM DanhGia ORDER BY id DESC", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    DanhGia dg = new DanhGia(
                            cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                            cursor.getString(cursor.getColumnIndexOrThrow("tenKhachHang")),
                            cursor.getString(cursor.getColumnIndexOrThrow("tenSanPham")),
                            cursor.getInt(cursor.getColumnIndexOrThrow("soSao")),
                            cursor.getString(cursor.getColumnIndexOrThrow("noiDung")),
                            cursor.getString(cursor.getColumnIndexOrThrow("thoiGian"))
                    );
                    list.add(dg);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) cursor.close();
            db.close();
        }
        return list;
    }

    public long insert(DanhGia dg) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenKhachHang", dg.getTenKhachHang());
        values.put("tenSanPham", dg.getTenSanPham());
        values.put("soSao", dg.getSoSao());
        values.put("noiDung", dg.getNoiDung());
        values.put("thoiGian", dg.getThoiGian());
        long result = db.insert("DanhGia", null, values);
        db.close();
        return result;
    }

    public int update(DanhGia dg) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenKhachHang", dg.getTenKhachHang());
        values.put("tenSanPham", dg.getTenSanPham());
        values.put("soSao", dg.getSoSao());
        values.put("noiDung", dg.getNoiDung());
        values.put("thoiGian", dg.getThoiGian());
        int result = db.update("DanhGia", values, "id=?", new String[]{String.valueOf(dg.getId())});
        db.close();
        return result;
    }

    public int delete(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int result = db.delete("DanhGia", "id=?", new String[]{String.valueOf(id)});
        db.close();
        return result;
    }
}
