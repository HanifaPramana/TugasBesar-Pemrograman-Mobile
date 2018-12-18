package com.example.lim.kulinermalang.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.example.lim.kulinermalang.R;
import com.example.lim.kulinermalang.activity_home;
import com.example.lim.kulinermalang.maps.maps_stmj;
import com.squareup.picasso.Picasso;

public class detail_stmj extends AppCompatActivity {

    //deklarasi variabel
    ImageView stmj1;
    CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menampilkan konten detail yang terkait
        setContentView(R.layout.detail_stmj);

        //set gambar dari URL
        String imageUri = "https://scontent-sea1-1.cdninstagram.com/vp/25a0cf16e1fd6dfe9a91b115f653b5a6/5C5CCA35/t51.2885-15/sh0.08/e35/s750x750/17076859_227114461093544_3072861938498142208_n.jpg?ig_cache_key=MTQ2MjM1MzkyNTExMDEwMzQwNg%3D%3D.2";
        //menghubungkan layout dengan activity melalui ID
        stmj1 = (ImageView) findViewById(R.id.stmj);

        //fungsi dari picasso
        Picasso.with(this).load(imageUri).into(stmj1);

        //instansiasi objek imageview berdasarkan id yang terkait
        ImageView img = (ImageView) findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),activity_home.class);
                startActivity(i);
                finish();
            }
        });

        //instansiasi objek cardview berdasarkan id yang terkait
        card1 = (CardView) findViewById(R.id.lokasi);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),maps_stmj.class);
                startActivity(i);
            }
        });
    }
}
