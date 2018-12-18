package com.example.lim.kulinermalang.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.example.lim.kulinermalang.R;
import com.example.lim.kulinermalang.activity_home;
import com.example.lim.kulinermalang.maps.maps_galuh;
import com.squareup.picasso.Picasso;

public class detail_acilgaluh extends AppCompatActivity {

    //deklarasi variabel
    ImageView acil;
    CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menampilkan konten detail yang terkait
        setContentView(R.layout.detail_acilgaluh);

        //set gambar dari URL
        String imageUri = "https://drive.thunder.id/file/public/2/4/2017/11/25/11/acil%201.jpg";
        //menghubungkan layout dengan activity melalui ID
        acil = (ImageView) findViewById(R.id.acilgaluh);

        //fungsi dari picasso
        Picasso.with(this).load(imageUri).into(acil);

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
                Intent i = new Intent(getApplicationContext(),maps_galuh.class);
                startActivity(i);
            }
        });
    }
}
