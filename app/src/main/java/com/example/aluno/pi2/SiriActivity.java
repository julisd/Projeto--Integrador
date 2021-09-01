package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SiriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siri);

        ImageButton testeSiri = (ImageButton) findViewById(R.id.testeSiri);

        testeSiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SiriComprarActivity.class);
                startActivity(it);
                finish();
            }
        });

        ImageButton LibrasSiri = (ImageButton) findViewById(R.id.imgbtnLibrasSiri);

        LibrasSiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), YoutubeGeral.class);

                it.putExtra("url", "yx7esHmAhL4");
                startActivity(it);
            }
        });
    }
}