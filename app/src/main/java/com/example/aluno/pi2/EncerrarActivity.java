package com.example.aluno.pi2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class EncerrarActivity extends AppCompatActivity {


    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encerrar);


        bd = openOrCreateDatabase("Restaurante", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS pedido (id INTEGER PRIMARY KEY AUTOINCREMENT, pratoOrBebida INT(100), obsRetirar INT(20), obsColocar INT(20),nomePrato VARCHAR(34523), quant INT(30), valor REAL(5.2))");
    }

    public void acabou(View v){
        bd.execSQL("drop table pedido");
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(it);
    }

    public void EscolherForma (View v) {
        LayoutInflater inflater =  getLayoutInflater();

        View view = inflater.inflate(R.layout.formade, (ViewGroup) findViewById(R.id.toastLayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);
        toast.show();

    }

    public void Dinheiro (View v) {
        LayoutInflater inflater =  getLayoutInflater();

        View view = inflater.inflate(R.layout.dinheiro, (ViewGroup) findViewById(R.id.toastLayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);
        toast.show();

    }

    public void Cartao (View v) {
        LayoutInflater inflater =  getLayoutInflater();

        View view = inflater.inflate(R.layout.cartao, (ViewGroup) findViewById(R.id.toastLayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);
        toast.show();

    }


}
