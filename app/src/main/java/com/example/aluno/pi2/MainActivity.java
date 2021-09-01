package com.example.aluno.pi2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{

    private SQLiteDatabase database;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        database = openOrCreateDatabase("Restaurante", MODE_PRIVATE, null);

        database.execSQL("CREATE TABLE IF NOT EXISTS pedido (id INTEGER PRIMARY KEY AUTOINCREMENT, pratoOrBebida INT(100), obsRetirar INT(20), obsColocar INT(20),nomePrato VARCHAR(34523), quant INT(30), valor REAL(5.2))");

        //database.execSQL("drop table pedido");

        Button btnCardapio = (Button) findViewById(R.id.btnCardapio);
        btnCardapio.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Tela2Activity.class);
                startActivity(it);


            }
        });

        //Schmidt

        ImageButton btnCardapioLibras = (ImageButton) findViewById(R.id.btnIconeCardapioLibras);
        btnCardapioLibras.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =  getLayoutInflater();

                View view = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toastLayout));
                Toast toast = new Toast(getApplicationContext());
                toast.setView(view);
                toast.show();

            }
        });

        ImageButton btnCarrinho = (ImageButton) findViewById(R.id.imgbtnCarrinhoMain);
        btnCarrinho.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ExemploScrollViewActivity.class);
                startActivity(it);
            }
        });
    }

}
