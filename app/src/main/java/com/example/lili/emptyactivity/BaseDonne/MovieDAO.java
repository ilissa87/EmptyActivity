package com.example.lili.emptyactivity.BaseDonne;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lili on 07/11/2017.
 */

public class MovieDAO {
    private static String TABLE_NAME="Movies";
    private static String COLUNM_NAME_TITLE="title";

    public static void create(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+TABLE_NAME+ " ( "+ "id INTEGER PRIMERY KEY AUTOINCREMENT "+COLUNM_NAME_TITLE
        +" TITRE NOT NULL )");

    }
    public static void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }
    public static void insert(SQLiteDatabase db, Movie v){
        ContentValues values=new ContentValues();
        values.put(COLUNM_NAME_TITLE, v.getTitle());
        values.putNull("id");
        db.insert(TABLE_NAME, null, values);
    }
    public static void deleteFromId(SQLiteDatabase  db, long id) {
        db.delete(TABLE_NAME, "id= ?", new String[]{
                String.valueOf(id)
        });
    }
    public static void deleteFromTitre(SQLiteDatabase db, String title){
        db.delete(TABLE_NAME, COLUNM_NAME_TITLE+ "=?", new String[]{title});

    }

    }


