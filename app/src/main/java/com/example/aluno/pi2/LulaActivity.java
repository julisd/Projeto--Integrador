package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LulaActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lula);

        ImageButton testeLula = (ImageButton) findViewById(R.id.testeLula);

        testeLula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), LulaCompraActivity.class);
                startActivity(it);
                finish();
            }
        });
    }

    public void onClick(View v) {
        Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

        it.putExtra("url", "kwxl_TCzNGc");
        startActivity(it);
    }
}