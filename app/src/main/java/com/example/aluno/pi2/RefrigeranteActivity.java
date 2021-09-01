package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RefrigeranteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrigerante);

        ImageButton testeRefri = (ImageButton) findViewById(R.id.testeRefri);

        testeRefri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), RefriCompraActivity.class);
                startActivity(it);
                finish();
            }
        });
    }

    public void onClick(View v) {
        Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

        it.putExtra("url", "whwyGW19E4U");
        startActivity(it);
    }
}
