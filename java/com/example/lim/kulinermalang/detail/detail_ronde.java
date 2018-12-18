package com.example.lim.kulinermalang.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.example.lim.kulinermalang.R;
import com.example.lim.kulinermalang.activity_home;
import com.example.lim.kulinermalang.maps.maps_ronde;
import com.squareup.picasso.Picasso;

public class detail_ronde extends AppCompatActivity {

    //deklarasi variabel
    ImageView ronde1;
    CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menampilkan konten detail yang terkait
        setContentView(R.layout.detail_ronde);

        //set gambar dari URL
        String imageUri = "https://media.travelingyuk.com/wp-content/uploads/2018/07/Ronde-Titoni-di-Malang-Kuliner-Malam-Legendaris-Sejak-1948-2.jpg";
        //menghubungkan layout dengan activity melalui ID
        ronde1 = (ImageView) findViewById(R.id.ronde);

        //fungsi dari picasso
        Picasso.with(this).load(imageUri).into(ronde1);

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
                Intent i = new Intent(getApplicationContext(),maps_ronde.class);
                startActivity(i);
            }
        });
    }
}
