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

import objetos.PratoPedido;
import objetos.Pratos;
import web.dadosViaPost;

public class SorveteComprarActivity extends AppCompatActivity {

    String qtd;
    int quant = 0;

    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorvete_compra);

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

        ImageButton btnqtdLibras = (ImageButton) findViewById(R.id.librasqtdSorvete);
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

        float valorTotal = quant * 8;

        int ObsRetirar = 0;
        int obsAdicionar = 0;

        CheckBox palito = findViewById(R.id.palitosCk);
        CheckBox morango = findViewById(R.id.morangoCk);
        CheckBox hortela = findViewById(R.id.hortelaCk);
        CheckBox leite = findViewById(R.id.leiteCondensadoCk);

        if(leite.isChecked()){
            obsAdicionar=obsAdicionar+1;
        }
        if(morango.isChecked()){
            obsAdicionar=obsAdicionar+2;
        }
        if(hortela.isChecked()){
            ObsRetirar=ObsRetirar+1;
        }
        if(palito.isChecked()){
            ObsRetirar=ObsRetirar+2;
        }

        bd = openOrCreateDatabase("Restaurante", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS pedido (id INTEGER PRIMARY KEY AUTOINCREMENT, pratoOrBebida INT(100), obsRetirar INT(20), obsColocar INT(20),nomePrato VARCHAR(34523), quant INT(30), valor REAL(5.2))");
        bd.execSQL("INSERT INTO pedido(pratoOrBebida, obsRetirar, obsColocar,nomePrato, quant, valor) VALUES (6, " + ObsRetirar + ", " + obsAdicionar + ", 'Sorvete de Chocolate', " + quant + "," + valorTotal + ")");

        Toast.makeText(getApplicationContext(), "Prato inserido ao pedido", Toast.LENGTH_LONG).show();

        Pratos prato = new Pratos();
        prato.setNome("Sorvete de Chocolate");
        prato.setPreco(8);

        PratoPedido pedido = new PratoPedido();
        pedido.setPrato(prato);
        pedido.setObs(obsAdicionar);
        pedido.setQtPratoPedido(quant);
        pedido.setSubTotal(valorTotal);

        dadosViaPost dbEx = new dadosViaPost();
        try {
            dbEx.mandarPedidoPrato(pedido);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void backzao(View v) {

        Intent it = new Intent(getApplicationContext(), SorveteActivity.class);
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
