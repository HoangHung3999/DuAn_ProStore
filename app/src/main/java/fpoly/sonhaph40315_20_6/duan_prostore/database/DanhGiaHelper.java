package fpoly.sonhaph40315_20_6.duan_prostore.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fpoly.sonhaph40315_20_6.duan_prostore.adapter.DanhGiaAdapter;

public class DanhGiaHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "danhgia.db";
    private static final int DATABASE_VERSION = 1;

    public DanhGiaHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE DanhGia (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenKhachHang TEXT," +
                "tenSanPham TEXT," +
                "soSao INTEGER," +
                "noiDung TEXT," +
                "thoiGian TEXT)";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS DanhGia");
        onCreate(db);
    }
}
