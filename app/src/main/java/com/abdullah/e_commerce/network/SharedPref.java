package com.abdullah.e_commerce.network;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref
{
    private static SharedPreferences mSharedPref;
      SharedPreferences.Editor prefsEditor = mSharedPref.edit();
    public static final String Token = "token";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String IS_SELECT = "IS_SELECT";
    public static final String LAT = "latitude";
    public static final String LNG = "longitude";
    public static final String MY_ADDRESS = "myAddress";


    private SharedPref()
    {

    }

    public static void init(Context context)
    {
        if(mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public static Integer read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value).apply();
    }
    public static void removePlaceObj(String kye) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.remove(kye);
        prefsEditor.apply();
    }

    public static void clearAll() {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.clear();
        prefsEditor.apply();
    }
}