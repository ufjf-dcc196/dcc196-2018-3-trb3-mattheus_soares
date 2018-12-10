package com.example.mattheus.trabalho03dcc196;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListarJogadoresActivity extends AppCompatActivity {

    private static Aventura aventura;
    private Integer id_aventura;
    private static TextView lbl_nome, lbl_desc, lbl_forca, lbl_destreza, lbl_nervos, lbl_const, lbl_mente, lbl_synth, lbl_sabedoria, lbl_carisma;
    private Button btn_editar_aventura, btn_cadastrar_jogador;
    public static final String ID_AVENTURA_LST = "ID da Aventura";
    public static final String ID_JOGADOR_LST = "ID do Jogador";
    public static final int REQUEST_EDITAR_AVENTURA= 1;
    public static final int REQUEST_CADASTRAR_JOGADOR= 2;
    public static final int REQUEST_LISTAR_JOGADOR= 3;
    private RecyclerView recyclerView;
    private static ListarJogadoresAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_jogadores);

        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();

        id_aventura = bundleResult.getInt(MainActivity.ID_AVENTURA);
        aventura = AventuraDAO.getInstance().getAventuraByID(id_aventura);

        recyclerView = findViewById(R.id.rcl_jogadores);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListarJogadoresAdapter(JogadorDAO.getInstance().getJogadoresDaAventura(id_aventura));
        recyclerView.setAdapter(adapter);

        lbl_nome = findViewById(R.id.lbl_jogador_nome);
        lbl_desc = findViewById(R.id.lbl_jogador_desc);
        lbl_forca = findViewById(R.id.lbl_avent_forca);
        lbl_destreza = findViewById(R.id.lbl_avent_destreza);
        lbl_nervos = findViewById(R.id.lbl_avent_nervos);
        lbl_const = findViewById(R.id.lbl_avent_const);
        lbl_mente = findViewById(R.id.lbl_avent_mente);
        lbl_synth = findViewById(R.id.lbl_avent_synth);
        lbl_sabedoria = findViewById(R.id.lbl_avent_sabedoria);
        lbl_carisma = findViewById(R.id.lbl_avent_carisma);

        btn_editar_aventura = findViewById(R.id.btn_Editar_Jogador);
        btn_cadastrar_jogador = findViewById(R.id.btn_Cadastrar_Jogador);

        updateStatus();

        adapter.setOnJogadorClickListener(new ListarJogadoresAdapter.OnJogadorClickListener() {
            @Override
            public void OnJogadorClick(View view, int position) {
                Integer id_jogador = JogadorDAO.getInstance().getJogadores().get(position).getId();
                Intent intent = new Intent(ListarJogadoresActivity.this, DetalhesJogadorActivity.class);
                intent.putExtra(ListarJogadoresActivity.ID_JOGADOR_LST,id_jogador);
                startActivityForResult(intent, ListarJogadoresActivity.REQUEST_LISTAR_JOGADOR);

            }


            @Override
            public void OnJogadorLongClick(View view, int position) {
                Integer id_jog = JogadorDAO.getInstance().getJogadores().get(position).getId();
                JogadorDAO.getInstance().deleteJogador(id_jog);

                adapter.setJogadores(JogadorDAO.getInstance().getJogadoresDaAventura(id_aventura));
                adapter.notifyItemRemoved(position);
            }
        });



        btn_editar_aventura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarJogadoresActivity.this, EditarAventuraActivity.class);
                intent.putExtra(ListarJogadoresActivity.ID_AVENTURA_LST,id_aventura);
                startActivityForResult(intent, ListarJogadoresActivity.REQUEST_EDITAR_AVENTURA);
            }
        });


        btn_cadastrar_jogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarJogadoresActivity.this, CadastrarJogadorActivity.class);
                intent.putExtra(ListarJogadoresActivity.ID_AVENTURA_LST,id_aventura);
                startActivityForResult(intent, ListarJogadoresActivity.REQUEST_CADASTRAR_JOGADOR);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

    }

    public static void updateStatus(){

        adapter.notifyDataSetChanged();

        lbl_nome.setText("Nome: "+aventura.getNome());
        lbl_desc.setText("Descrição: "+aventura.getDescricao());
        lbl_forca.setText("Força: "+aventura.getForca());
        lbl_destreza.setText("Destreza: "+aventura.getDestreza());
        lbl_nervos.setText("Nervos: "+aventura.getNervos());
        lbl_const.setText("Constituição: "+aventura.getConstituicao());
        lbl_mente.setText("Mente: "+aventura.getMente());
        lbl_synth.setText("Synth: "+aventura.getSynth());
        lbl_sabedoria.setText("Sabedoria: "+aventura.getSabedoria());
        lbl_carisma.setText("Carisma: "+aventura.getCarisma());
    }
}
