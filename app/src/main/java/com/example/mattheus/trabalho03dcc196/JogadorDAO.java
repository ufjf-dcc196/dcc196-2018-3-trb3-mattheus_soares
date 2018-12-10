package com.example.mattheus.trabalho03dcc196;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class JogadorDAO {

    private static JogadorDAO instance = new JogadorDAO();
    private RPGDBHelper rpgdbHelper;
    private Cursor cursor;

    private JogadorDAO(){}

    public static JogadorDAO getInstance() {
        return instance;
    }

    public void inicializarDBHelper(Context c) {
        rpgdbHelper = new RPGDBHelper(c);
    }

    public ArrayList<Jogador> getJogadores() {

        ArrayList<Jogador> jogadores = new ArrayList<>();

        SQLiteDatabase db = rpgdbHelper.getReadableDatabase();

        String[] visao = {
                RPGContract.JogadorTable.COLUMN_NAME_NOME,
                RPGContract.JogadorTable.COLUMN_NAME_CLASSE,
                RPGContract.JogadorTable.COLUMN_NAME_FORCA,
                RPGContract.JogadorTable.COLUMN_NAME_DESTREZA,
                RPGContract.JogadorTable.COLUMN_NAME_NERVOS,
                RPGContract.JogadorTable.COLUMN_NAME_CONSTITUICAO,
                RPGContract.JogadorTable.COLUMN_NAME_MENTE,
                RPGContract.JogadorTable.COLUMN_NAME_SYNTH,
                RPGContract.JogadorTable.COLUMN_NAME_SABEDORIA,
                RPGContract.JogadorTable.COLUMN_NAME_CARISMA,
                RPGContract.JogadorTable.COLUMN_NAME_ID_AVENTURA,
                RPGContract.JogadorTable._ID
        };
        cursor = db.query(RPGContract.JogadorTable.TABLE_NAME, visao,
                null, null, null, null, null);

        int id_Jogador_Nome = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_NOME);
        int id_Jogador_Classe = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CLASSE);
        int id_Jogador_Forca = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_FORCA);
        int id_Jogador_Destreza = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_DESTREZA);
        int id_Jogador_Nervos = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_NERVOS);
        int id_Jogador_Const = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CONSTITUICAO);
        int id_Jogador_Mente = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_MENTE);
        int id_Jogador_Synth = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_SYNTH);
        int id_Jogador_Sabedoria = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_SABEDORIA);
        int id_Jogador_Carisma = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CARISMA);
        int id_Jogador_ID_Aventura = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_ID_AVENTURA);
        int id_Jogador_ID = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable._ID);

        if (cursor.moveToFirst()) {
            do {
                Jogador aux = new Jogador();
                aux.setId(Integer.parseInt(cursor.getString(id_Jogador_ID)));
                aux.setNome(cursor.getString(id_Jogador_Nome));
                aux.setClasse(cursor.getString(id_Jogador_Classe));
                aux.setForca(cursor.getString(id_Jogador_Forca));
                aux.setDestreza(cursor.getString(id_Jogador_Destreza));
                aux.setNervos(cursor.getString(id_Jogador_Nervos));
                aux.setConstituicao(cursor.getString(id_Jogador_Const));
                aux.setMente(cursor.getString(id_Jogador_Mente));
                aux.setSynth(cursor.getString(id_Jogador_Synth));
                aux.setSabedoria(cursor.getString(id_Jogador_Sabedoria));
                aux.setCarisma(cursor.getString(id_Jogador_Carisma));
                aux.setId_aventura(cursor.getString(id_Jogador_ID_Aventura));
                jogadores.add(aux);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return jogadores;
    }


    public Jogador getJogadorByID(Integer id_jogador){
        Jogador jogador = new Jogador();

        SQLiteDatabase db = rpgdbHelper.getReadableDatabase();

        int id_Jogador_Nome = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_NOME);
        int id_Jogador_Classe = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CLASSE);
        int id_Jogador_Forca = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_FORCA);
        int id_Jogador_Destreza = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_DESTREZA);
        int id_Jogador_Nervos = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_NERVOS);
        int id_Jogador_Const = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CONSTITUICAO);
        int id_Jogador_Mente = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_MENTE);
        int id_Jogador_Synth = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_SYNTH);
        int id_Jogador_Sabedoria = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_SABEDORIA);
        int id_Jogador_Carisma = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CARISMA);
        int id_Jogador_ID_Aventura = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_ID_AVENTURA);
        int id_Jogador_ID = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable._ID);


        String query = "SELECT * FROM "+RPGContract.JogadorTable.TABLE_NAME+" WHERE _ID = ?";
        cursor = db.rawQuery(query , new String[]{String.valueOf(id_jogador)});

        if(cursor.moveToFirst()){
            jogador.setId(Integer.parseInt(cursor.getString(id_Jogador_ID)));
            jogador.setNome(cursor.getString(id_Jogador_Nome));
            jogador.setClasse(cursor.getString(id_Jogador_Classe));
            jogador.setForca(cursor.getString(id_Jogador_Forca));
            jogador.setDestreza(cursor.getString(id_Jogador_Destreza));
            jogador.setNervos(cursor.getString(id_Jogador_Nervos));
            jogador.setConstituicao(cursor.getString(id_Jogador_Const));
            jogador.setMente(cursor.getString(id_Jogador_Mente));
            jogador.setSynth(cursor.getString(id_Jogador_Synth));
            jogador.setSabedoria(cursor.getString(id_Jogador_Sabedoria));
            jogador.setCarisma(cursor.getString(id_Jogador_Carisma));
            jogador.setId_aventura(cursor.getString(id_Jogador_ID_Aventura));
        }
        cursor.close();


        return jogador;
    }


    public ArrayList<Jogador> getJogadoresDaAventura(Integer id_aventura){
        ArrayList<Jogador> jogadores = new ArrayList<>();
        SQLiteDatabase db = rpgdbHelper.getReadableDatabase();

        String query = "SELECT * FROM "+RPGContract.JogadorTable.TABLE_NAME+" WHERE "+RPGContract.JogadorTable.COLUMN_NAME_ID_AVENTURA+" = ?";
        cursor = db.rawQuery(query , new String[]{String.valueOf(id_aventura)});

        if(cursor.moveToFirst()) {
            int id_Jogador_Nome = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_NOME);
            int id_Jogador_Classe = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CLASSE);
            int id_Jogador_Forca = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_FORCA);
            int id_Jogador_Destreza = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_DESTREZA);
            int id_Jogador_Nervos = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_NERVOS);
            int id_Jogador_Const = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CONSTITUICAO);
            int id_Jogador_Mente = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_MENTE);
            int id_Jogador_Synth = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_SYNTH);
            int id_Jogador_Sabedoria = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_SABEDORIA);
            int id_Jogador_Carisma = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_CARISMA);
            int id_Jogador_ID_Aventura = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable.COLUMN_NAME_ID_AVENTURA);
            int id_Jogador_ID = cursor.getColumnIndexOrThrow(RPGContract.JogadorTable._ID);

            do {
                Jogador aux = new Jogador();
                aux.setId(Integer.parseInt(cursor.getString(id_Jogador_ID)));
                aux.setNome(cursor.getString(id_Jogador_Nome));
                aux.setClasse(cursor.getString(id_Jogador_Classe));
                aux.setForca(cursor.getString(id_Jogador_Forca));
                aux.setDestreza(cursor.getString(id_Jogador_Destreza));
                aux.setNervos(cursor.getString(id_Jogador_Nervos));
                aux.setConstituicao(cursor.getString(id_Jogador_Const));
                aux.setMente(cursor.getString(id_Jogador_Mente));
                aux.setSynth(cursor.getString(id_Jogador_Synth));
                aux.setSabedoria(cursor.getString(id_Jogador_Sabedoria));
                aux.setCarisma(cursor.getString(id_Jogador_Carisma));
                aux.setId_aventura(cursor.getString(id_Jogador_ID_Aventura));
                jogadores.add(aux);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return jogadores;
    }

    public void insertJogador(Jogador jogador, Integer id_aventura){
        SQLiteDatabase db = rpgdbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(RPGContract.JogadorTable.COLUMN_NAME_NOME,jogador.getNome());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_CLASSE,jogador.getClasse());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_FORCA,jogador.getForca());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_DESTREZA,jogador.getDestreza());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_NERVOS,jogador.getNervos());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_CONSTITUICAO,jogador.getConstituicao());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_MENTE,jogador.getMente());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_SYNTH,jogador.getSynth());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_SABEDORIA,jogador.getSabedoria());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_CARISMA,jogador.getCarisma());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_ID_AVENTURA,Integer.toString(id_aventura));

        db.insert(RPGContract.JogadorTable.TABLE_NAME,null,cv);

    }


    public void deleteJogador(Integer ID_Jogador){
        SQLiteDatabase db = rpgdbHelper.getWritableDatabase();
        db.delete(RPGContract.JogadorTable.TABLE_NAME,"_ID = ?", new String[]{String.valueOf(ID_Jogador)});
    }

    public void deleteJogadorDaAventura(Integer ID_Aventura){
        SQLiteDatabase db = rpgdbHelper.getWritableDatabase();
        db.delete(RPGContract.JogadorTable.TABLE_NAME,RPGContract.JogadorTable.COLUMN_NAME_ID_AVENTURA+" = ?", new String[]{String.valueOf(ID_Aventura)});
    }

    public void updateJogador(Jogador jogador, Integer id_jogador) {
        SQLiteDatabase db = rpgdbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(RPGContract.JogadorTable.COLUMN_NAME_NOME,jogador.getNome());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_CLASSE,jogador.getClasse());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_FORCA,jogador.getForca());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_DESTREZA,jogador.getDestreza());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_NERVOS,jogador.getNervos());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_CONSTITUICAO,jogador.getConstituicao());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_MENTE,jogador.getMente());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_SYNTH,jogador.getSynth());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_SABEDORIA,jogador.getSabedoria());
        cv.put(RPGContract.JogadorTable.COLUMN_NAME_CARISMA,jogador.getCarisma());

        db.update(RPGContract.JogadorTable.TABLE_NAME,cv,"_ID = ?", new String[]{String.valueOf(id_jogador)});

    }

}
