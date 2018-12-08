package com.example.mattheus.trabalho03dcc196;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ListarAventurasAdapter adapter;
    private Button btn_cadastrar_aventura;
    private RecyclerView recyclerView;
    public static final String POSICAO_AVENTURA = "Posição da Aventura";
    public static final int REQUEST_CADASTRO_AVENTURA= 1;
    public static final int REQUEST_LISTAR_AVENTURA= 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AventuraDAO.getInstance().inicializarDBHelper(getApplicationContext());

        btn_cadastrar_aventura = findViewById(R.id.btn_Cadastrar_Aventura);

        recyclerView = findViewById(R.id.rcl_aventuras);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListarAventurasAdapter(AventuraDAO.getInstance().getAventuras());
        recyclerView.setAdapter(adapter);

        adapter.setOnAventuraClickListener(new ListarAventurasAdapter.OnAventuraClickListener() {
            @Override
            public void OnAventuraClick(View view, int position) {
                Integer id_avent = Integer.parseInt(AventuraDAO.getInstance().getAventuras().get(position).getId());
                Intent intent = new Intent(MainActivity.this, ListarJogadoresActivity.class);
                intent.putExtra(MainActivity.POSICAO_AVENTURA,id_avent);
                startActivityForResult(intent, MainActivity.REQUEST_LISTAR_AVENTURA);

            }

            @Override
            public void OnAventuraLongClick(View view, int position) {
                Integer id_avent = Integer.parseInt(AventuraDAO.getInstance().getAventuras().get(position).getId());
                AventuraDAO.getInstance().deleteAventura(id_avent);
                /*
                *
                * REMOVER JOGADORES DA AVENTURA
                *
                * */
                adapter.setAventuras(AventuraDAO.getInstance().getAventuras());
                adapter.notifyItemRemoved(position);

            }
        });

        btn_cadastrar_aventura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastrarAventuraActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_CADASTRO_AVENTURA);

            }
        });


    }
    public static void refresh(){
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter.setAventuras(AventuraDAO.getInstance().getAventuras());
    }

}
