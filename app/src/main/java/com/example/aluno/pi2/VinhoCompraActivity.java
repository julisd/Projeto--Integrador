package com.example.aluno.pi2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class VinhoCompraActivity  extends AppCompatActivity {

    String qtd;
    int quant = 0;

    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinho_comprar);

        final TextView tvQtd = (TextView) findViewById(R.id.txtQtd);
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

        ImageButton btnqtdLibras = (ImageButton) findViewById(R.id.librasqtdVinho);
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

    public void clicando(View view){

        float valorTotal = quant * 45;

        bd = openOrCreateDatabase("Restaurante", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS pedido (id INTEGER PRIMARY KEY AUTOINCREMENT, pratoOrBebida INT(100), obsRetirar INT(20), obsColocar INT(20),nomePrato VARCHAR(34523), quant INT(30), valor REAL(5.2))");
        bd.execSQL("INSERT INTO pedido(pratoOrBebida, nomePrato, quant, valor) VALUES (5, 'Casillero Del Diablo', " + quant + "," + valorTotal + ")");

        Toast.makeText(getApplicationContext(), "Bebida inserida ao pedido", Toast.LENGTH_LONG).show();

        Bebidas bebida = new Bebidas();
        bebida.setNome("Casillero Del Diablo");
        bebida.setPreco(45);

        BebidaPedido pedido = new BebidaPedido();
        pedido.setBebida(bebida);
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

        Intent it = new Intent(getApplicationContext(), VinhoActivity.class);
        startActivity(it);
        finish();
    }

}

