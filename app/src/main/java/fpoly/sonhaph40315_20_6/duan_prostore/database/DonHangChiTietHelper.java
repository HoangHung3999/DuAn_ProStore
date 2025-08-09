package fpoly.sonhaph40315_20_6.duan_prostore.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DonHangChiTietHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DonHangChiTiet.db";
    private static final int DATABASE_VERSION = 1;

    public DonHangChiTietHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE DonHangChiTiet (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "orderId INTEGER, " +
                "productId INTEGER, " +
                "soLuong INTEGER, " +
                "giaTien REAL, " +
                "username TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS DonHangChiTiet");
        onCreate(db);
    }
}
