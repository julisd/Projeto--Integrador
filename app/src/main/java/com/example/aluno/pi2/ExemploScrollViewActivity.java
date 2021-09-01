package com.example.aluno.pi2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExemploScrollViewActivity extends AppCompatActivity {

    private SQLiteDatabase bd;
    public float valor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_scrollview);
        bd = openOrCreateDatabase("Restaurante", MODE_PRIVATE, null);
        Cursor cursor = bd.rawQuery("SELECT nomePrato, quant, valor FROM pedido", null);
        cursor.moveToFirst();

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
        LayoutInflater inflater = LayoutInflater.from(this);

        TextView texto = (TextView) inflater.inflate(R.layout.layout_text2, layout, false);
        String pedido ="PEDIDO \n";
        texto.setText(pedido);
        layout.addView(texto);

        for(int i = 0; i < cursor.getCount(); i++) {
            TextView text = (TextView) inflater.inflate(R.layout.layout_teste, layout, false);

            String linha = (cursor.getString(0) +"\n                                          qtd: "+ cursor.getString(1) +"\n                                    valor: "+ cursor.getString(2) + "\n");
            text.setText(linha);
            layout.addView(text);
            valor = valor + Float.parseFloat(cursor.getString(2));
            cursor.moveToNext();
        }
        TextView text = (TextView) inflater.inflate(R.layout.layout_teste, layout, false);
        String valorS ="_____________________________\nValor Total                      R$ "+valor+"\n\n";
        text.setText(valorS);
        layout.addView(text);


        ImageButton btnEncerrarLibras = (ImageButton) findViewById(R.id.encerrarConta);
        btnEncerrarLibras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =  getLayoutInflater();

                View view = inflater.inflate(R.layout.encerrar, (ViewGroup) findViewById(R.id.toastLayout));
                Toast toast = new Toast(getApplicationContext());
                toast.setView(view);
                toast.show();

            }
        });

    }

    public void encerrar(View v){

        if(valor == 0){
            Toast.makeText(getApplicationContext(), "Faça seu pedido!", Toast.LENGTH_LONG).show();
        }else{
            Intent it = new Intent(getApplicationContext(), EncerrarActivity.class);
            startActivity(it);
        }


    }


    public void limpar(View v) {

        bd.execSQL("DELETE FROM pedido");
        Toast.makeText(getApplicationContext(), "Pedido excluído, volte ao cardápio!", Toast.LENGTH_LONG).show();

    }

}
