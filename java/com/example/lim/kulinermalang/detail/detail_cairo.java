package com.example.lim.kulinermalang.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.example.lim.kulinermalang.R;
import com.example.lim.kulinermalang.activity_home;
import com.example.lim.kulinermalang.maps.maps_cairo;
import com.squareup.picasso.Picasso;

public class detail_cairo extends AppCompatActivity {

    //deklarasi variabel
    ImageView cairo1;
    CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menampilkan konten detail yang terkait
        setContentView(R.layout.detail_cairo);

        //set gambar dari URL
        String imageUri = "https://www.gotravelly.com/assets/img/tinymce/d3439f76d9ad2fcaa73b283bae6b34aa.jpg";
        //menghubungkan layout dengan activity melalui ID
        cairo1 = (ImageView) findViewById(R.id.cairo);

        //fungsi dari picasso
        Picasso.with(this).load(imageUri).into(cairo1);

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
                Intent i = new Intent(getApplicationContext(),maps_cairo.class);
                startActivity(i);
            }
        });
    }
}
