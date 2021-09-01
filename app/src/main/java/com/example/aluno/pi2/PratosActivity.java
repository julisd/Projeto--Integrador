package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PratosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratos);

        Button btnSalmao = (Button) findViewById(R.id.btnSalmao);
        btnSalmao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SalmaoActivity.class);
                startActivity(it);
            }
        });

        Button btnChuchu = (Button) findViewById(R.id.btnChuchu);
        btnChuchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ChuchuActivity.class);
                startActivity(it);
            }
        });


        Button btnSiri = (Button) findViewById(R.id.btnSiri);
        btnSiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SiriActivity.class);
                startActivity(it);
            }
        });


        Button btnFrutos = (Button) findViewById(R.id.btnFrutos);
        btnFrutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), FrutosActivity.class);
                startActivity(it);
            }
        });

        Button btnLula = (Button) findViewById(R.id.btnLula);
        btnLula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), LulaActivity.class);
                startActivity(it);
            }
        });

        Button btnSorvete = (Button) findViewById(R.id.btnSorvete);
        btnSorvete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SorveteActivity.class);
                startActivity(it);
            }
        });

        ImageButton imgbtnCarrinho = (ImageButton) findViewById(R.id.imgbtnCarrinhoPartos);
        imgbtnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ExemploScrollViewActivity.class);
                startActivity(it);
            }
        });

    }
}
