package com.example.finallayout.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.finallayout.Class.MyClass;
import com.example.finallayout.Database.ClassDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    private SQLiteDatabase db=null;
    private SQLiteOpenHelper dbHelper;
    private Context context;

    public ClassDAO(Context context){
        this.context = context;
        dbHelper = new ClassDatabase(context);
        db = dbHelper.getWritableDatabase();
    }

    public int CreateClass(MyClass myClass){
        ContentValues values = new ContentValues();
        values.put("className", myClass.getName());
        values.put("classID", myClass.getId());
        values.put("classMajor", myClass.getMajor());
        values.put("classSign", myClass.getSign());
        values.put("classLesson", myClass.getLesson());
        values.put("classBase", myClass.getBase());
        values.put("classTeacher", myClass.getTeacher());

        long kq = db.insert("class", null, values);
        if (kq <= 0){
            return -1;
        }
        return 1;
    }

    public List<MyClass> getAllClass(){
        List<MyClass> classList = new ArrayList<>();
        Cursor c = db.query("class",null, null, null,
                null, null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            MyClass myClass = new MyClass();
            myClass.setName(c.getString(0));
            myClass.setId(c.getString(1));
            myClass.setMajor(c.getString(2));
            myClass.setSign(c.getString(3));
            myClass.setLesson(c.getString(4));
            myClass.setBase(c.getString(5));

            classList.add(myClass);
            c.moveToNext();
        }
        c.close();
        return classList;
    }

    public int UpdateClass(MyClass myClass){
        ContentValues values = new ContentValues();
        values.put("className", myClass.getName());
        values.put("classID", myClass.getId());
        values.put("classMajor", myClass.getMajor());
        values.put("classSign", myClass.getSign());
        values.put("classLesson", myClass.getLesson());
        values.put("classBase", myClass.getBase());
        values.put("classTeacher", myClass.getTeacher());

        long kq = db.update("class",values,"classID=?",new String[]{myClass.getId()});
        if (kq <= 0){
            return -1;
        }
        return 1;
    }

    public int DeleteClass(String id){
        long kq = db.delete("class","classID=?",new String[]{id});
        if (kq <= 0)
            return -1;
        return 0;
    }
}
