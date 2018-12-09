package com.example.mattheus.trabalho03dcc196;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarJogadorActivity extends AppCompatActivity {

    private Integer id_aventura;
    private Button btn_cadastrar_jogador;
    private EditText txt_nome, txt_classe, txt_forca, txt_destreza, txt_nervos, txt_const, txt_mente, txt_synth, txt_sabedoria, txt_carisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_jogador);

        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();
        id_aventura = bundleResult.getInt(ListarJogadoresActivity.ID_AVENTURA_LST);

        txt_nome = findViewById(R.id.txt_nome_jogador);
        txt_classe = findViewById(R.id.txt_classe_jogador);
        txt_forca = findViewById(R.id.txt_forca_jogador);
        txt_destreza = findViewById(R.id.txt_destreza_jogador);
        txt_nervos = findViewById(R.id.txt_nervos_jogador);
        txt_const = findViewById(R.id.txt_const_jogador);
        txt_mente = findViewById(R.id.txt_mente_jogador);
        txt_synth = findViewById(R.id.txt_synth_jogador);
        txt_sabedoria = findViewById(R.id.txt_sabedoria_jogador);
        txt_carisma = findViewById(R.id.txt_carisma_jogador);
        btn_cadastrar_jogador = findViewById(R.id.btn_salvar_jogador);

        btn_cadastrar_jogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(txt_nome.getText().toString()) || txt_nome.getText() ==null
                        || txt_classe.getText().toString().equals("") || txt_classe.getText()==null
                        || txt_forca.getText().toString().equals("") || txt_forca.getText()==null
                        || txt_destreza.getText().toString().equals("") || txt_destreza.getText()==null
                        || txt_nervos.getText().toString().equals("") || txt_nervos.getText()==null
                        || txt_const.getText().toString().equals("") || txt_const.getText()==null
                        || txt_mente.getText().toString().equals("") || txt_mente.getText()==null
                        || txt_synth.getText().toString().equals("") || txt_synth.getText()==null
                        || txt_sabedoria.getText().toString().equals("") || txt_sabedoria.getText()==null
                        || txt_carisma.getText().toString().equals("") || txt_carisma.getText()==null) {
                    Toast t = Toast.makeText(getApplicationContext(), "Favor preencher todos os campos", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }else{

                    Intent resultado = new Intent();

                    Jogador jogador = new Jogador();
                    jogador.setNome(txt_nome.getText().toString());
                    jogador.setClasse(txt_classe.getText().toString());
                    jogador.setForca(txt_forca.getText().toString());
                    jogador.setDestreza(txt_destreza.getText().toString());
                    jogador.setNervos(txt_nervos.getText().toString());
                    jogador.setConstituicao(txt_const.getText().toString());
                    jogador.setMente(txt_mente.getText().toString());
                    jogador.setSynth(txt_synth.getText().toString());
                    jogador.setSabedoria(txt_sabedoria.getText().toString());
                    jogador.setCarisma(txt_carisma.getText().toString());
                    jogador.setId_aventura(id_aventura.toString());

                    JogadorDAO.getInstance().insertJogador(jogador,id_aventura);
                    ListarJogadoresActivity.updateStatus();

                    setResult(Activity.RESULT_OK, resultado);
                    finish();

                }
            }
        });


    }
}
