package com.example.mattheus.trabalho03dcc196;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class CadastrarAventuraActivity extends AppCompatActivity {

    private Button btn_cadastrar_aventura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_aventura);

        btn_cadastrar_aventura = findViewById(R.id.btn_salvar_aventura);
    }
}
