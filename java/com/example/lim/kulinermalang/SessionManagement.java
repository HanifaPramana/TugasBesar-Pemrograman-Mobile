package com.example.lim.kulinermalang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class SessionManagement extends AppCompatActivity {
    //deklarasi Share preference
    private SharedPreferences mSharedPreference;
    //deklarasi Editor untuk Shared preference
    private SharedPreferences.Editor mEditor;
    //deklarasi context
    private Context mContext;
    //deklarasi Shared pref mode
    int PRIVATE_MODE;
    //nama Shared pref
    private static final String PREF_NAME = "SharedPrefLatihan";
    //Shared Preferences Keys utama
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "UserName";
    public static final String KEY_PASSWORD = "UserName";
    public SessionManagement(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME,
                PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }

    //metode untuk session login
    public void createLoginSession(String UserName, String Password){
        //menyimpan nilai login sebagai TRUE
        mEditor.putBoolean(IS_LOGIN, true);
        // menyimpan username
        mEditor.putString(KEY_USERNAME, Password);
        // menyimpan password
        mEditor.putString(KEY_PASSWORD, UserName);
        mEditor.commit();
    }

    //method untuk get dan put
    public HashMap<String, String> getUserInformation(){
        HashMap<String, String> user = new HashMap<String, String>();
        // username
        user.put(KEY_USERNAME, mSharedPreference.getString(KEY_USERNAME, null));
        // password
        user.put(KEY_PASSWORD, mSharedPreference.getString(KEY_PASSWORD,
                null));
        // return user
        return user;
    }

    //method jika user telah login
    public boolean isLoggedIn(){
        return mSharedPreference.getBoolean(IS_LOGIN, false);
    }

    public void checkIsLogin() {
        // Check login status
        if (!isLoggedIn()) {
            // user is not logged in redirect to MainActivity
            Intent i = new Intent(mContext, activity_login.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }

    //method logout user
    public void logoutUser(){
        // membersihkan semua data dari Shared Preference
        mEditor.clear();
        mEditor.commit();

        // setelah logout redirect user ke activity login
        Intent i = new Intent(mContext, activity_login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }

}

