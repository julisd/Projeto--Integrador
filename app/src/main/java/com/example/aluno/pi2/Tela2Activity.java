package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Tela2Activity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Button btnBebidas = (Button) findViewById(R.id.btnBebidas);
        btnBebidas.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), BebidasActivity.class);
                startActivity(it);

            }
        });

        Button btnPratos = (Button) findViewById(R.id.btnPratos);
        btnPratos.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(), PratosActivity.class);
                startActivity(it);
            }
        });

        ImageButton btnBebidasLibras = (ImageButton) findViewById(R.id.btnLibras);
        btnBebidasLibras.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =  getLayoutInflater();

                View view = inflater.inflate(R.layout.custom_toast_2, (ViewGroup) findViewById(R.id.toastLayout));
                Toast toast = new Toast(getApplicationContext());
                toast.setView(view);
                toast.show();
            }
        });

        ImageButton btnPratosLibras = (ImageButton) findViewById(R.id.btnLibras2);
        btnPratosLibras.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =  getLayoutInflater();

                View view = inflater.inflate(R.layout.custom_toast_3, (ViewGroup) findViewById(R.id.toastLayout));
                Toast toast = new Toast(getApplicationContext());
                toast.setView(view);
                toast.show();
            }
        });

        ImageButton imgbtnCarrinho = (ImageButton) findViewById(R.id.imgbtnCarrinhoMain2);
        imgbtnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ExemploScrollViewActivity.class);
                startActivity(it);
            }
        });
    }
}










