package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;


public class VinhoActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinho);


        ImageButton testeVinho= (ImageButton) findViewById(R.id.testeVinho);

        testeVinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), VinhoCompraActivity.class);
                startActivity(it);
                finish();
            }
        });





    }

    public void onClick(View v) {
        Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

        it.putExtra("url", "6zCgQp_dN1w");
        startActivity(it);
    }

}
