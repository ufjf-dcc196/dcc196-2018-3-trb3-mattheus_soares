package com.example.mattheus.trabalho03dcc196;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RPGDBHelper extends SQLiteOpenHelper {
    public final static int DATABASE_VERSION = 1;
    public final static String DATABASE_NAME = "RPGDBHelper.db";

    public RPGDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(RPGContract.AventuraTable.SQL_CREATE_AVENTURA);
        db.execSQL(RPGContract.JogadorTable.SQL_CREATE_JOGADOR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(RPGContract.JogadorTable.SQL_DROP_JOGADOR);
        db.execSQL(RPGContract.AventuraTable.SQL_DROP_AVENTURA);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
