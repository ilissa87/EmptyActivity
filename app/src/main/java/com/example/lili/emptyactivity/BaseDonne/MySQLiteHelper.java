package com.example.lili.emptyactivity.BaseDonne;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lili on 07/11/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
   private static final String BD_NAME="myfirstDB.db";
    private static final int DB_VERSION=1;
    public MySQLiteHelper(Context context ) {
        super(context,BD_NAME ,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       MovieDAO.create(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        MovieDAO.drop(db);
        MovieDAO.create(db);

    }
}
