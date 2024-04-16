package com.example.finallayout.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClassDatabase extends SQLiteOpenHelper {

    public static final String SQL_class = "CREATE TABLE class(" +
            " className TEXT, " +
            " classID TEXT PRIMARY KEY, " +
            " classMajor TEXT, " +
            " classSign TEXT, " +
            " classLesson TEXT, " +
            " classBase TEXT, " +
            " classTeacher TEXT);";

    public ClassDatabase(Context context){
        super(context, "Class.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SQL_class");
    }
}
