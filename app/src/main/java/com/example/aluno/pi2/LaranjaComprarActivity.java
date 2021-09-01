package com.example.aluno.pi2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import objetos.BebidaPedido;
import objetos.Bebidas;
import web.dadosViaPost;


public class LaranjaComprarActivity extends AppCompatActivity {

    String qtd;
    int quant = 0;

    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laranja_compra);

        final TextView tvQtd = (TextView) findViewById(R.id.txtQtddd);
        ImageButton btnMais = (ImageButton) findViewById(R.id.btnMais);
        ImageButton btnMenos = (ImageButton) findViewById(R.id.btnMenos);

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quant++;
                qtd = Integer.toString(quant);
                tvQtd.setText(qtd);
            }
        });


        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ARRUMAR MSG DO TOAST
                quant--;
                if (quant <= 0){
                    Toast.makeText(getApplicationContext(), "N dá", Toast.LENGTH_LONG);
                    quant = 0;
                }else{
                    qtd = Integer.toString(quant);
                    tvQtd.setText(qtd);
                }
            }
        });

        ImageButton btnqtdLibras = (ImageButton) findViewById(R.id.librasqtdLaranja);
        btnqtdLibras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =  getLayoutInflater();

                View view = inflater.inflate(R.layout.custom_toast_qtd, (ViewGroup) findViewById(R.id.toastLayout));
                Toast toast = new Toast(getApplicationContext());
                toast.setView(view);
                toast.show();

            }
        });


    }

    public void clicando(View view) {

        float valorTotal = quant * 6;

        int obsAdicionar = 0;

        CheckBox adocante = findViewById(R.id.adocanteCk);
        CheckBox acucar = findViewById(R.id.acucarCk);

        if (acucar.isChecked()) {
            obsAdicionar = obsAdicionar + 1;
        }
        if (adocante.isChecked()) {
            obsAdicionar = obsAdicionar + 2;
        }


        bd = openOrCreateDatabase("Restaurante", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS pedido (id INTEGER PRIMARY KEY AUTOINCREMENT, pratoOrBebida INT(100), obsRetirar INT(20), obsColocar INT(20),nomePrato VARCHAR(34523), quant INT(30), valor REAL(5.2))");
        bd.execSQL("INSERT INTO pedido(pratoOrBebida, obsColocar,nomePrato, quant, valor) VALUES (2, " + obsAdicionar + ", 'Suco de Laranja', " + quant + "," + valorTotal + ")");

        Toast.makeText(getApplicationContext(), "Bebida inserida ao pedido", Toast.LENGTH_LONG).show();

        Bebidas bebida = new Bebidas();
        bebida.setNome("Suco de Laranja");
        bebida.setPreco(6);

        BebidaPedido pedido = new BebidaPedido();
        pedido.setBebida(bebida);
        pedido.setObs(obsAdicionar);
        pedido.setQtBebidaPedido(quant);
        pedido.setSubTotal(valorTotal);

        dadosViaPost dbEx = new dadosViaPost();
        try {
            dbEx.mandarPedidoBebida(pedido);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void backzao(View v) {

        Intent it = new Intent(getApplicationContext(), SucoLaranjaActivity.class);
        startActivity(it);
        finish();
    }

    public void adicionar(View v) {
        Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

        it.putExtra("url", "4z2ZT4bJiWM");
        startActivity(it);
    }


}
