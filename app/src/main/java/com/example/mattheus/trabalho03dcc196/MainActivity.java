package com.example.mattheus.trabalho03dcc196;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_cadastrar_aventura;
    public static final String POSICAO_AVENTURA = "Posição da Aventura";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cadastrar_aventura = findViewById(R.id.btn_Cadastrar_Aventura);


        recyclerView = findViewById(R.id.rcl_aventuras);
    }
}
