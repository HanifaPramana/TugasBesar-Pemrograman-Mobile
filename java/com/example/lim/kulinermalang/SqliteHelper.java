package com.example.lim.kulinermalang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    //nama database
    public static final String DATABASE_NAME = "sqlite.db";

    //versi database
    public static final int DATABASE_VERSION = 1;

    //nama tabel
    public static final String TABLE_USERS = "users";

    //kolom tabel user
    //kolom id (primary key)
    public static final String KEY_ID = "id";

    //kolom username
    public static final String KEY_USER_NAME = "username";

    //kolom email
    public static final String KEY_EMAIL = "email";

    //kolom password
    public static final String KEY_PASSWORD = "password";

    //SQL untuk membuat tabel user
    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT"
            + " ) ";

    //untuk mendapatkan akses ke dalam Database
    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //membuat tabel ketika onCreate dipanggil
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //menghapus tabel untuk membuat tabel baru jika versi database diperbarui
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
    }

    //menggunakan method ini, kita bisa menambahkan user ke tabel user
    public void addUser(User user) {

        //fungsi supaya database bisa membaca data didalamnya
        SQLiteDatabase db = this.getWritableDatabase();

        //menyimpan 1 set nilai
        ContentValues values = new ContentValues();

        // meletakkan username di values
        values.put(KEY_USER_NAME, user.userName);

        // meletakkan email di values
        values.put(KEY_EMAIL, user.email);

        // meletakkan password di values
        values.put(KEY_PASSWORD, user.password);

        // memasukkan baris ke table user
        long todo_id = db.insert(TABLE_USERS, null, values);
    }


    public User Authenticate(User user) {
        //fungsi supaya database bisa membaca data didalamnya
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, //memilih tabel
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL, KEY_PASSWORD}, //memilih kolom yang ingin di query
                KEY_USER_NAME + "=?",
                new String[]{user.userName}, //dimana klausa
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount()>0) {
            //kalau kursor mempunya nilai, maka di database User ada user yang terkait dengan email yang diberikan
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

            //mencocokkan kedua password apakah sama atau tidak
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }

        //kalau password user tidak cocok dengan UserName maka false
        return null;
    }

    public boolean isUserNameExists(String userName) {
        //fungsi supaya database bisa membaca data didalamnya
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL, KEY_PASSWORD},//Selecting columns want to query //memilih kolom yang ingin di kueri
                KEY_USER_NAME + "=?",
                new String[]{userName},//Where clause //dimana klausa
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //kalau kursor punya nilai, maka di database user ada user yang terkait dengan email yang diberikan jadi true
            return true;
        }

        //kalau UserName tidak ada di databse maka false
        return false;
    }
}