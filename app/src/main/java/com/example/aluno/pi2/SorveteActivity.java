package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SorveteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorvete);

        ImageButton testeSorvete = (ImageButton) findViewById(R.id.testeSorvete);

        testeSorvete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SorveteComprarActivity.class);
                startActivity(it);
                finish();
            }
        });
    }

    public void onClick(View v) {
        Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

        it.putExtra("url", "oi0Vczvdz6A");
        startActivity(it);
    }
}