package com.example.mattheus.trabalho03dcc196;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalhesJogadorActivity extends AppCompatActivity {

    private TextView lbl_nome, lbl_classe, lbl_forca, lbl_destreza, lbl_nervos, lbl_const, lbl_mente, lbl_synth, lbl_sabedoria, lbl_carisma;
    private Button btn_editar_jogador;
    private Integer id_jogador;
    private Jogador jogador;
    public static final String ID_JOGADOR_LST = "ID do Jogador";
    public static final int REQUEST_EDITAR_JOGADOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_jogador);

        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();

        id_jogador = bundleResult.getInt(ListarJogadoresActivity.ID_JOGADOR_LST);
        jogador = JogadorDAO.getInstance().getJogadorByID(id_jogador);

        lbl_nome = findViewById(R.id.lbl_jogador_nome);
        lbl_classe = findViewById(R.id.lbl_jogador_classe);
        lbl_forca = findViewById(R.id.lbl_jogador_forca);
        lbl_destreza = findViewById(R.id.lbl_jogador_destreza);
        lbl_nervos = findViewById(R.id.lbl_jogador_nervos);
        lbl_const = findViewById(R.id.lbl_jogador_const);
        lbl_mente = findViewById(R.id.lbl_jogador_mente);
        lbl_synth = findViewById(R.id.lbl_jogador_synth);
        lbl_sabedoria = findViewById(R.id.lbl_jogador_sabedoria);
        lbl_carisma = findViewById(R.id.lbl_jogador_carisma);

        btn_editar_jogador = findViewById(R.id.btn_Editar_Jogador);

        lbl_nome.setText("Nome: "+jogador.getNome());
        lbl_classe.setText("Classe: "+jogador.getClasse());
        lbl_forca.setText("Força: "+jogador.getForca());
        lbl_destreza.setText("Destreza: "+jogador.getDestreza());
        lbl_nervos.setText("Nervos: "+jogador.getNervos());
        lbl_const.setText("Constituição: "+jogador.getConstituicao());
        lbl_mente.setText("Mente: "+jogador.getMente());
        lbl_synth.setText("Synth: "+jogador.getSynth());
        lbl_sabedoria.setText("Sabedoria: "+jogador.getSabedoria());
        lbl_carisma.setText("Carisma: "+jogador.getCarisma());

        btn_editar_jogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalhesJogadorActivity.this, EditarJogadorActivity.class);
                intent.putExtra(DetalhesJogadorActivity.ID_JOGADOR_LST,id_jogador);
                startActivityForResult(intent, DetalhesJogadorActivity.REQUEST_EDITAR_JOGADOR);
            }
        });
    }
}
