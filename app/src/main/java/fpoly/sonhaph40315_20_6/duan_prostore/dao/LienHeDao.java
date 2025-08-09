package fpoly.sonhaph40315_20_6.duan_prostore.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.LineNumberReader;
import java.util.ArrayList;

import fpoly.sonhaph40315_20_6.duan_prostore.database.LienHeHelper;
import fpoly.sonhaph40315_20_6.duan_prostore.model.LienHe;

public class LienHeDao {
    private final LienHeHelper dbHelper;

    public LienHeDao(Context context) {
        dbHelper = new LienHeHelper(context);
    }

    public boolean insertContact(LienHe contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("phone", contact.getPhone());
        values.put("email", contact.getEmail());
        values.put("address", contact.getAddress());
        values.put("message", contact.getMessage());
        values.put("date", contact.getDate());

        long result = db.insert("Contact", null, values);
        return result != -1;
    }


    public boolean updateContact(LienHe contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("phone", contact.getPhone());
        values.put("email", contact.getEmail());
        values.put("address", contact.getAddress());
        values.put("message", contact.getMessage());
        values.put("date", contact.getDate());

        int result = db.update("Contact", values, "id = ?", new String[]{String.valueOf(contact.getId())});
        return result > 0;
    }

    public ArrayList<LienHe> getAllContacts() {
        ArrayList<LienHe> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Contact", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                String email = cursor.getString(3);
                String address = cursor.getString(4);
                String message = cursor.getString(5);
                String date = cursor.getString(6);
                list.add(new LienHe(id, name, phone, email, address, message,date));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void deleteContact(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Contact", "id=?", new String[]{String.valueOf(id)});
    }
}
