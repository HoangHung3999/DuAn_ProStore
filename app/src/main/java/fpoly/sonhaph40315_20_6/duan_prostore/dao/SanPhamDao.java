package fpoly.sonhaph40315_20_6.duan_prostore.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.database.SanPhamHelper;
import fpoly.sonhaph40315_20_6.duan_prostore.model.SanPham;

public class SanPhamDao {
    private final SanPhamHelper dbHelper;

    public SanPhamDao(Context context) {
        dbHelper = new SanPhamHelper(context);
    }

    // Thêm sản phẩm
    public long insertProduct(SanPham product) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(SanPhamHelper.COLUMN_NAME, product.getName());
        values.put(SanPhamHelper.COLUMN_PRICE, product.getPrice());
        values.put(SanPhamHelper.COLUMN_QUANTITY, product.getQuantity());
        values.put(SanPhamHelper.COLUMN_SIZE, product.getSize());
        values.put(SanPhamHelper.COLUMN_CATEGORY, product.getCategory());
        values.put(SanPhamHelper.COLUMN_IMAGE_PATH, product.getImagePath());
        values.put(SanPhamHelper.COLUMN_DATE, product.getDate());  // <--- thêm dòng này

        long result = db.insert(SanPhamHelper.TABLE_NAME, null, values);
        db.close();
        return result;
    }


    // Lấy danh sách sản phẩm
    public List<SanPham> getAllProducts() {
        List<SanPham> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + SanPhamHelper.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(SanPhamHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(SanPhamHelper.COLUMN_NAME));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow(SanPhamHelper.COLUMN_PRICE));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(SanPhamHelper.COLUMN_QUANTITY));
                String size = cursor.getString(cursor.getColumnIndexOrThrow(SanPhamHelper.COLUMN_SIZE));
                String category = cursor.getString(cursor.getColumnIndexOrThrow(SanPhamHelper.COLUMN_CATEGORY));
                String imagePath = cursor.getString(cursor.getColumnIndexOrThrow(SanPhamHelper.COLUMN_IMAGE_PATH));
                String date = cursor.getString(cursor.getColumnIndexOrThrow(SanPhamHelper.COLUMN_DATE));

                SanPham product = new SanPham(id, name, price, quantity, size, category, imagePath,date);
                list.add(product);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;
    }

    // Cập nhật sản phẩm
    public int updateProduct(SanPham product) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(SanPhamHelper.COLUMN_NAME, product.getName());
        values.put(SanPhamHelper.COLUMN_PRICE, product.getPrice());
        values.put(SanPhamHelper.COLUMN_QUANTITY, product.getQuantity());
        values.put(SanPhamHelper.COLUMN_SIZE, product.getSize());
        values.put(SanPhamHelper.COLUMN_CATEGORY, product.getCategory());
        values.put(SanPhamHelper.COLUMN_IMAGE_PATH, product.getImagePath());
        values.put(SanPhamHelper.COLUMN_DATE, product.getDate());  // <--- thêm dòng này

        int result = db.update(
                SanPhamHelper.TABLE_NAME,
                values,
                SanPhamHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(product.getId())}
        );

        db.close();
        return result;
    }


    // Xóa sản phẩm
    public int deleteProduct(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int result = db.delete(
                SanPhamHelper.TABLE_NAME,
                SanPhamHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}
        );
        db.close();
        return result;
    }


}
