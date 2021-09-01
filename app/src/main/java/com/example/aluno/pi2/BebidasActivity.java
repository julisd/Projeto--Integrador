package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import web.dadosViaPost;

public class BebidasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        Button btnAgua = (Button) findViewById(R.id.btnAgua);
        btnAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AguaActivity.class);

                startActivity(it);
            }
        });

        Button btnSucoLaranja = (Button) findViewById(R.id.btnSucoLaranja);
        btnSucoLaranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SucoLaranjaActivity.class);
                startActivity(it);
            }
        });

        Button btnSucoMorango = (Button) findViewById(R.id.btnSucoMorango);
        btnSucoMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SucoMorangoActivity.class);
                startActivity(it);
            }
        });

        Button btnRefrigerante = (Button) findViewById(R.id.btnRefrigerante);
        btnRefrigerante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), RefrigeranteActivity.class);
                startActivity(it);
            }
        });

        Button btnVinho = (Button) findViewById(R.id.btnVinho);
        btnVinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), VinhoActivity.class);
                startActivity(it);
            }
        });

        ImageButton imgbtnCarrinho = (ImageButton) findViewById(R.id.imgbtnCarrinhoBebidas);
        imgbtnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ExemploScrollViewActivity.class);
                startActivity(it);
            }
        });
    }
}
