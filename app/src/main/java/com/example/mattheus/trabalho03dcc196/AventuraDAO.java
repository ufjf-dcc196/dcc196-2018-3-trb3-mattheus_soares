package com.example.mattheus.trabalho03dcc196;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AventuraDAO {

    private static AventuraDAO instance = new AventuraDAO();
    private RPGDBHelper rpgdbHelper;
    private Cursor cursor;

    private AventuraDAO() {}

    public static AventuraDAO getInstance() {
        return instance;
    }

    public void inicializarDBHelper(Context c) {
        rpgdbHelper = new RPGDBHelper(c);
    }


    public ArrayList<Aventura> getAventuras() {
        ArrayList<Aventura> aventuras = new ArrayList<>();
        SQLiteDatabase db = rpgdbHelper.getReadableDatabase();
        String[] visao = {
                RPGContract.AventuraTable.COLUMN_NAME_NOME,
                RPGContract.AventuraTable.COLUMN_NAME_DESCRICAO,
                RPGContract.AventuraTable.COLUMN_NAME_FORCA,
                RPGContract.AventuraTable.COLUMN_NAME_DESTREZA,
                RPGContract.AventuraTable.COLUMN_NAME_NERVOS,
                RPGContract.AventuraTable.COLUMN_NAME_CONSTITUICAO,
                RPGContract.AventuraTable.COLUMN_NAME_MENTE,
                RPGContract.AventuraTable.COLUMN_NAME_SYNTH,
                RPGContract.AventuraTable.COLUMN_NAME_SABEDORIA,
                RPGContract.AventuraTable.COLUMN_NAME_CARISMA,
                RPGContract.AventuraTable._ID
        };
        String query = "SELECT * FROM "+RPGContract.AventuraTable.TABLE_NAME;
        cursor = db.rawQuery(query,null);

        int id_Aventura_Nome = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_NOME);
        int id_Aventura_Descricao = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_DESCRICAO);
        int id_Aventura_Forca = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_FORCA);
        int id_Aventura_Destreza = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_DESTREZA);
        int id_Aventura_Nervos = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_NERVOS);
        int id_Aventura_Const = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_CONSTITUICAO);
        int id_Aventura_Mente = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_MENTE);
        int id_Aventura_Synth = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_SYNTH);
        int id_Aventura_Sabedoria = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_SABEDORIA);
        int id_Aventura_Carisma = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_CARISMA);
        int id_Aventura_ID = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable._ID);
        if (cursor.moveToFirst()) {
            do {
                Aventura aux = new Aventura();
                aux.setId(cursor.getString(id_Aventura_ID));
                aux.setNome(cursor.getString(id_Aventura_Nome));
                aux.setDescricao(cursor.getString(id_Aventura_Descricao));
                aux.setForca(cursor.getString(id_Aventura_Forca));
                aux.setDestreza(cursor.getString(id_Aventura_Destreza));
                aux.setNervos(cursor.getString(id_Aventura_Nervos));
                aux.setConstituicao(cursor.getString(id_Aventura_Const));
                aux.setMente(cursor.getString(id_Aventura_Mente));
                aux.setSynth(cursor.getString(id_Aventura_Synth));
                aux.setSabedoria(cursor.getString(id_Aventura_Sabedoria));
                aux.setCarisma(cursor.getString(id_Aventura_Carisma));
                aventuras.add(aux);
            } while (cursor.moveToNext());
            cursor.close();

        }
        return aventuras;
    }

    public Aventura getAventuraByID(Integer ID_Aventura){
        Aventura aventura = new Aventura();

        SQLiteDatabase db = rpgdbHelper.getReadableDatabase();

        int id_Aventura_Nome = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_NOME);
        int id_Aventura_Descricao = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_DESCRICAO);
        int id_Aventura_Forca = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_FORCA);
        int id_Aventura_Destreza = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_DESTREZA);
        int id_Aventura_Nervos = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_NERVOS);
        int id_Aventura_Const = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_CONSTITUICAO);
        int id_Aventura_Mente = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_MENTE);
        int id_Aventura_Synth = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_SYNTH);
        int id_Aventura_Sabedoria = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_SABEDORIA);
        int id_Aventura_Carisma = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable.COLUMN_NAME_CARISMA);
        int id_Aventura_ID = cursor.getColumnIndexOrThrow(RPGContract.AventuraTable._ID);


        String query = "SELECT * FROM "+RPGContract.AventuraTable.TABLE_NAME+" WHERE _ID = ?";
        cursor = db.rawQuery(query , new String[]{String.valueOf(ID_Aventura)});

        if(cursor.moveToFirst()){
            aventura.setId(cursor.getString(id_Aventura_ID));
            aventura.setNome(cursor.getString(id_Aventura_Nome));
            aventura.setDescricao(cursor.getString(id_Aventura_Descricao));
            aventura.setForca(cursor.getString(id_Aventura_Forca));
            aventura.setDestreza(cursor.getString(id_Aventura_Destreza));
            aventura.setNervos(cursor.getString(id_Aventura_Nervos));
            aventura.setConstituicao(cursor.getString(id_Aventura_Const));
            aventura.setMente(cursor.getString(id_Aventura_Mente));
            aventura.setSynth(cursor.getString(id_Aventura_Synth));
            aventura.setSabedoria(cursor.getString(id_Aventura_Sabedoria));
            aventura.setCarisma(cursor.getString(id_Aventura_Carisma));

            cursor.close();
        }
        return aventura;
    }

    public void insertAventura(Aventura aventura){
        SQLiteDatabase db = rpgdbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_NOME,aventura.getNome());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_DESCRICAO,aventura.getDescricao());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_FORCA,aventura.getForca());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_DESTREZA,aventura.getDestreza());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_NERVOS,aventura.getNervos());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_CONSTITUICAO,aventura.getConstituicao());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_MENTE,aventura.getMente());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_SYNTH,aventura.getSynth());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_SABEDORIA,aventura.getSabedoria());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_CARISMA,aventura.getCarisma());
        db.insert(RPGContract.AventuraTable.TABLE_NAME,null,cv);
    }

    public void deleteAventura(Integer ID_Aventura){
        SQLiteDatabase db = rpgdbHelper.getWritableDatabase();
        db.delete(RPGContract.AventuraTable.TABLE_NAME,"_ID = ?", new String[]{String.valueOf(ID_Aventura)});
    }

    public void updateAventura(Aventura aventura){
        SQLiteDatabase db = rpgdbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(RPGContract.AventuraTable.COLUMN_NAME_NOME,aventura.getNome());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_DESCRICAO,aventura.getDescricao());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_FORCA,aventura.getForca());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_DESTREZA,aventura.getDestreza());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_NERVOS,aventura.getNervos());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_CONSTITUICAO,aventura.getConstituicao());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_MENTE,aventura.getMente());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_SYNTH,aventura.getSynth());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_SABEDORIA,aventura.getSabedoria());
        cv.put(RPGContract.AventuraTable.COLUMN_NAME_CARISMA,aventura.getCarisma());

        db.update(RPGContract.AventuraTable.TABLE_NAME,cv,"_ID = ?", new String[]{String.valueOf(aventura.getId())});
    }
}
