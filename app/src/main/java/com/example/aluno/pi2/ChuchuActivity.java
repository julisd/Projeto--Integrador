package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChuchuActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuchu);

        ImageButton testeChuchu = (ImageButton) findViewById(R.id.testeChuchu);

        testeChuchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ChuchuCompraActivity.class);
                startActivity(it);
                finish();
            }
        });
    }

    public void onClick(View v) {
        Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

        it.putExtra("url", "OTy9GJQ19SE");
        startActivity(it);
    }
}