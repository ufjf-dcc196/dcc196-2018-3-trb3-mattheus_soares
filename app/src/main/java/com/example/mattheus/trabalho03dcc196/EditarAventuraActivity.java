package com.example.mattheus.trabalho03dcc196;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditarAventuraActivity extends AppCompatActivity {

    private Aventura aventura;
    private Integer id_aventura;
    private Button btn_editar_aventura;
    private EditText txt_nome, txt_desc, txt_forca, txt_destreza, txt_nervos, txt_const, txt_mente, txt_synth, txt_sabedoria, txt_carisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_aventura);

        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();
        id_aventura = bundleResult.getInt(ListarJogadoresActivity.ID_AVENTURA_LST);
        aventura = AventuraDAO.getInstance().getAventuraByID(id_aventura);

        txt_nome = findViewById(R.id.txt_edt_nome_aventura);
        txt_desc = findViewById(R.id.txt_edt_desc_aventura);
        txt_forca = findViewById(R.id.txt_edt_forca_aventura);
        txt_destreza = findViewById(R.id.txt_edt_destreza_aventura);
        txt_nervos = findViewById(R.id.txt_edt_nervos_aventura);
        txt_const = findViewById(R.id.txt_edt_const_aventura);
        txt_mente = findViewById(R.id.txt_edt_mente_aventura);
        txt_synth = findViewById(R.id.txt_edt_synth_aventura);
        txt_sabedoria = findViewById(R.id.txt_edt_sabedoria_aventura);
        txt_carisma = findViewById(R.id.txt_edt_carisma_aventura);
        btn_editar_aventura = findViewById(R.id.btn_salvar_edt_aventura);

        setData();

        btn_editar_aventura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(txt_nome.getText().toString()) || txt_nome.getText() ==null
                        || txt_desc.getText().toString().equals("") || txt_desc.getText()==null
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

                    aventura = new Aventura();
                    aventura.setNome(txt_nome.getText().toString());
                    aventura.setDescricao(txt_desc.getText().toString());
                    aventura.setForca(txt_forca.getText().toString());
                    aventura.setDestreza(txt_destreza.getText().toString());
                    aventura.setNervos(txt_nervos.getText().toString());
                    aventura.setConstituicao(txt_const.getText().toString());
                    aventura.setMente(txt_mente.getText().toString());
                    aventura.setSynth(txt_synth.getText().toString());
                    aventura.setSabedoria(txt_sabedoria.getText().toString());
                    aventura.setCarisma(txt_carisma.getText().toString());

                    AventuraDAO.getInstance().updateAventura(aventura,id_aventura);
                    ListarJogadoresActivity.updateStatus();

                    setResult(Activity.RESULT_OK, resultado);
                    finish();
                }
            }
        });
    }
    private void setData(){
        txt_nome.setText(aventura.getNome());
        txt_desc.setText(aventura.getDescricao());
        txt_forca.setText(aventura.getForca());
        txt_destreza.setText(aventura.getDestreza());
        txt_nervos.setText(aventura.getNervos());
        txt_const.setText(aventura.getConstituicao());
        txt_mente.setText(aventura.getMente());
        txt_synth.setText(aventura.getSynth());
        txt_sabedoria.setText(aventura.getSabedoria());
        txt_carisma.setText(aventura.getCarisma());
    }

}
