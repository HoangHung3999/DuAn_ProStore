package fpoly.sonhaph40315_20_6.duan_prostore.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.database.UserHelper;
import fpoly.sonhaph40315_20_6.duan_prostore.model.User;

public class UserDao {
    private final UserHelper userHelper;
    private static final String TABLE_NAME = "users";

    public UserDao(Context context) {
        userHelper = new UserHelper(context);
    }

    // Thêm người dùng
    public boolean insertUser(String username, String email, String password, String role) {
        SQLiteDatabase db = userHelper.getWritableDatabase();

        // Kiểm tra email đã tồn tại chưa
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            cursor.close();
            return false; // Email đã tồn tại
        }

        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);
        values.put("role", role);

        long result = db.insert(TABLE_NAME, null, values);
        cursor.close();
        return result != -1;
    }

    // Đăng nhập
    public User checkLogin(String email, String password) {
        SQLiteDatabase db = userHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE email = ? AND password = ?",
                new String[]{email, password}
        );

        if (cursor.moveToFirst()) {
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            String userEmail = cursor.getString(2);
            String userPassword = cursor.getString(3);
            String role = cursor.getString(4);
            cursor.close();
            return new User(id, username, userEmail, userPassword, role);
        }
        cursor.close();
        return null;
    }

    // Lấy tất cả người dùng
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        SQLiteDatabase db = userHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String username = cursor.getString(1);
                String email = cursor.getString(2);
                String password = cursor.getString(3);
                String role = cursor.getString(4);

                list.add(new User(id, username, email, password, role));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    // Cập nhật người dùng
    public int updateUser(User user) {
        SQLiteDatabase db = userHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("email", user.getEmail());
        values.put("role", user.getRole());
        return db.update(TABLE_NAME, values, "id = ?", new String[]{String.valueOf(user.getId())});
    }

    // Xóa người dùng
    public int deleteUser(int userId) {
        SQLiteDatabase db = userHelper.getWritableDatabase();
        return db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(userId)});
    }
}
