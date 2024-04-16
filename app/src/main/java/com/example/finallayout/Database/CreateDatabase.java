package com.example.finallayout.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PublicKey;

public class CreateDatabase extends SQLiteOpenHelper {

    public static String TB_ACCOUNT = "ACCOUNT";

    public static String TB_ACCOUNT_USERNAME = "USERNAME";
    public static String TB_ACCOUNT_PASSWORD = "PASSWORD";
    public static String TB_ACCOUNT_IS_PROFESSOR = "IS_PROFESSOR";

    public CreateDatabase(Context context) {
        super(context, "ClassManagement", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbAccount = "CREATE TABLE " + TB_ACCOUNT + " ( " + TB_ACCOUNT_USERNAME + " TEXT PRIMARY KEY, "
                                                                + TB_ACCOUNT_PASSWORD + " TEXT, "
                                                                + TB_ACCOUNT_IS_PROFESSOR + " INTEGER )";

        db.execSQL(tbAccount);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
