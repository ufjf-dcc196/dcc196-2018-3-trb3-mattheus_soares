package com.example.mattheus.trabalho03dcc196;

import android.content.Context;
import android.database.Cursor;

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

}
