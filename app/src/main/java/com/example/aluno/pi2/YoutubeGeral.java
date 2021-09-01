package com.example.aluno.pi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

import web.VideoAdapter;
import web.YouTubeVideos;

public class YoutubeGeral extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        Intent intent = getIntent();
      //  Bundle bundle = intent.getBundleExtra("stringBundle");
      //  String umaString = bundle.getString("umaString");
        String mensagem = intent.getStringExtra("url");

        String src;
        src = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + mensagem+ "\" frameborder=\"0\" allowfullscreen></iframe>";

        //<iframe width="560" height="315" src="https://www.youtube.com/embed/1pLsb1YMsKE" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>

        youtubeVideos.add( new YouTubeVideos(src) );
        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }
}




