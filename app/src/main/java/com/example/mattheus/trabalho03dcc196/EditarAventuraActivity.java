package com.example.mattheus.trabalho03dcc196;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EditarAventuraActivity extends AppCompatActivity {
    private Button btn_editar_aventura;
    private TextView txt_nome, txt_desc, txt_forca, txt_destreza, txt_nervos, txt_const, txt_mente, txt_synth, txt_sabedoria, txt_carisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_aventura);


    }
}
