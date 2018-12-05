package com.example.mattheus.trabalho03dcc196;

import android.provider.BaseColumns;
import android.widget.ExpandableListView;

public class RPGContract {
    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER";
    public static final String SEP = ",";

    public static final class AventuraTable implements BaseColumns {
        public static final String TABLE_NAME = "Aventura";
        public static final String COLUMN_NAME_NOME = "Nome";
        public static final String COLUMN_NAME_DESCRICAO = "Descrição";
        public static final String COLUMN_NAME_FORCA = "Força";
        public static final String COLUMN_NAME_DESTREZA = "Destreza";
        public static final String COLUMN_NAME_NERVOS = "Nervos";
        public static final String COLUMN_NAME_CONSTITUICAO = "Constituição";
        public static final String COLUMN_NAME_MENTE = "Mente";
        public static final String COLUMN_NAME_SYNTH = "Synth";
        public static final String COLUMN_NAME_SABEDORIA = "Sabedoria";
        public static final String COLUMN_NAME_CARISMA = "Carisma";

        public static final String SQL_CREATE_AVENTURA = "CREATE TABLE " + AventuraTable.TABLE_NAME + " (" +
                AventuraTable._ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + SEP +
                AventuraTable.COLUMN_NAME_NOME + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_DESCRICAO + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_FORCA + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_DESTREZA + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_NERVOS + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_CONSTITUICAO + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_MENTE + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_SYNTH + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_SABEDORIA + TEXT_TYPE + SEP +
                AventuraTable.COLUMN_NAME_CARISMA + TEXT_TYPE + ")";
        public static final String SQL_DROP_AVENTURA = "DROP TABLE IF EXISTS" + AventuraTable.TABLE_NAME;
        public final static String SQL_DELETE_AVENTURA = "DELETE FROM" + AventuraTable.TABLE_NAME+ " WHERE id=" + AventuraTable._ID;



    }

    public static final class JogadorTable implements BaseColumns {
        public static final String TABLE_NAME = "Jogador";
        public static final String COLUMN_NAME_NOME = "Nome";
        public static final String COLUMN_NAME_CLASSE = "Classe";
        public static final String COLUMN_NAME_FORCA = "Força";
        public static final String COLUMN_NAME_DESTREZA = "Destreza";
        public static final String COLUMN_NAME_NERVOS = "Nervos";
        public static final String COLUMN_NAME_CONSTITUICAO = "Constituição";
        public static final String COLUMN_NAME_MENTE = "Mente";
        public static final String COLUMN_NAME_SYNTH = "Synth";
        public static final String COLUMN_NAME_SABEDORIA = "Sabedoria";
        public static final String COLUMN_NAME_CARISMA = "Carisma";
        public static final String COLUMN_NAME_ID_AVENTURA = "ID_Aventura";

        public static final String SQL_CREATE_JOGADOR = "CREATE TABLE " + JogadorTable.TABLE_NAME + " (" +
                JogadorTable._ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + SEP +
                JogadorTable.COLUMN_NAME_NOME + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_CLASSE + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_FORCA + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_DESTREZA + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_NERVOS + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_CONSTITUICAO + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_MENTE + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_SYNTH + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_SABEDORIA + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_CARISMA + TEXT_TYPE + SEP +
                JogadorTable.COLUMN_NAME_ID_AVENTURA + INT_TYPE + ")";
        public static final String SQL_DROP_JOGADOR = "DROP TABLE IF EXISTS" + JogadorTable.TABLE_NAME;
        public final static String SQL_DELETE_JOGADOR = "DELETE FROM" + JogadorTable.TABLE_NAME+ " WHERE id=" + JogadorTable._ID;


    }
}
