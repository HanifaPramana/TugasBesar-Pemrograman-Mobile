package com.example.lim.kulinermalang.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.example.lim.kulinermalang.R;
import com.example.lim.kulinermalang.activity_home;
import com.example.lim.kulinermalang.maps.maps_ketan;
import com.squareup.picasso.Picasso;

public class detail_ketan extends AppCompatActivity {

    //deklarasi variabel
    ImageView ketan1;
    CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menampilkan konten detail yang terkait
        setContentView(R.layout.detail_ketan);

        //set gambar dari URL
        String imageUri = "https://iklantravel.com/wp-content/uploads/2016/12/pos-ketan-legenda-1967-kota-batu.jpg";
        //menghubungkan layout dengan activity melalui ID
        ketan1 = (ImageView) findViewById(R.id.ketan);

        //fungsi dari picasso
        Picasso.with(this).load(imageUri).into(ketan1);

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
                Intent i = new Intent(getApplicationContext(),maps_ketan.class);
                startActivity(i);
            }
        });
    }
}
