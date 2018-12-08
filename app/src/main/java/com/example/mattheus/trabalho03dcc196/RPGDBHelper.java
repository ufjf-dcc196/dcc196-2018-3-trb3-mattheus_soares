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

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RPGContract.AventuraTable.COLUMN_NAME_NOME, "Aventura Inicial");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_DESCRICAO, "Encontro dos jogadores no esconderijo");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_FORCA, "10");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_DESTREZA, "9");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_NERVOS, "10");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_CONSTITUICAO, "9");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_MENTE, "8");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_SYNTH, "6");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_SABEDORIA, "10");
        values.put(RPGContract.AventuraTable.COLUMN_NAME_CARISMA, "11");

        db.insert(RPGContract.AventuraTable.TABLE_NAME, null, values);
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
