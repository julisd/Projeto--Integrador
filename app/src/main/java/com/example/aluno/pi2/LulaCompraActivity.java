package com.example.aluno.pi2;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import objetos.PratoPedido;
import objetos.Pratos;
import web.dadosViaPost;

public class LulaCompraActivity extends AppCompatActivity {

    String qtd;
    int quantt = 0;
    int ObsRetirar = 0;
    int obsAdicionar = 0;
    //ArrayList<String> infoPrato;

    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lula_compra);

        final TextView tvQtd = (TextView) findViewById(R.id.txtQtd);
        ImageButton btnMais = (ImageButton) findViewById(R.id.btnMais);
        ImageButton btnMenos = (ImageButton) findViewById(R.id.btnMenos);

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantt++;
                qtd = Integer.toString(quantt);
                tvQtd.setText(qtd);
            }
        });


        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ARRUMAR MSG DO TOAST
                quantt--;
                if (quantt <= 0){
                    Toast.makeText(getApplicationContext(), "N dá", Toast.LENGTH_LONG);
                    quantt = 0;
                }else{
                    qtd = Integer.toString(quantt);
                    tvQtd.setText(qtd);
                }
            }
        });

        ImageButton btnqtdLibras = (ImageButton) findViewById(R.id.librasqtdLula);
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

        float valorTotal = quantt * 52;

        CheckBox aze = findViewById(R.id.azeitonaCkkk);
        CheckBox cebola = findViewById(R.id.cebolaCk);
        CheckBox limao = findViewById(R.id.limaoCkk);
        CheckBox batata = findViewById(R.id.batataCk);
        CheckBox tomate = findViewById(R.id.tomateCkk);

        if (aze.isChecked()) {
            obsAdicionar = obsAdicionar + 1;
        }
        if (batata.isChecked()) {
            obsAdicionar = obsAdicionar + 2;
        }
        if (limao.isChecked()) {
            ObsRetirar = ObsRetirar + 1;
        }
        if (cebola.isChecked()) {
            ObsRetirar = ObsRetirar + 2;
        }
        if (tomate.isChecked()) {
            ObsRetirar = ObsRetirar + 4;
        }

        bd = openOrCreateDatabase("Restaurante", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS pedido(id INTEGER PRIMARY KEY AUTOINCREMENT, pratoOrBebida INT(100), obsRetirar INT(20), obsColocar INT(20),nomePrato VARCHAR(34523), quant INT(30), valor REAL(5.2))");
        bd.execSQL("INSERT INTO pedido(pratoOrBebida, obsRetirar, obsColocar,nomePrato, quant, valor) VALUES (5, " + ObsRetirar + ", " + obsAdicionar + ", 'Lula em Anéis', " + quantt + "," + valorTotal + ")");

        Toast.makeText(getApplicationContext(), "Prato inserido ao pedido", Toast.LENGTH_LONG).show();

        Pratos prato = new Pratos();
        prato.setNome("Lula em anéis");
        prato.setPreco(52);

        PratoPedido pedido = new PratoPedido();
        pedido.setPrato(prato);
        pedido.setObs(obsAdicionar);
        pedido.setQtPratoPedido(quantt);
        pedido.setSubTotal(valorTotal);

        dadosViaPost dbEx = new dadosViaPost();
        try {
            dbEx.mandarPedidoPrato(pedido);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void backzao(View v) {

        Intent it = new Intent(getApplicationContext(), LulaActivity.class);
        startActivity(it);
        finish();
    }

    public void adicionar(View v) {
        Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

        it.putExtra("url", "4z2ZT4bJiWM");
        startActivity(it);
    }

    public void retirar(View v) {
        Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

        it.putExtra("url", "eVDcMt27UTg");
        startActivity(it);
    }

}