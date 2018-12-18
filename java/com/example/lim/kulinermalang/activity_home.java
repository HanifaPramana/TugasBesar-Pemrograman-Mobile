package com.example.lim.kulinermalang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lim.kulinermalang.R;
import com.example.lim.kulinermalang.detail.detail_acilgaluh;
import com.example.lim.kulinermalang.detail.detail_cairo;
import com.example.lim.kulinermalang.detail.detail_ceker;
import com.example.lim.kulinermalang.detail.detail_hoklay;
import com.example.lim.kulinermalang.detail.detail_ketan;
import com.example.lim.kulinermalang.detail.detail_pecel;
import com.example.lim.kulinermalang.detail.detail_ronde;
import com.example.lim.kulinermalang.detail.detail_sate;
import com.example.lim.kulinermalang.detail.detail_stmj;

import java.util.HashMap;

public class activity_home extends AppCompatActivity {

    CardView card1;
    CardView card2;
    CardView card3;
    CardView card4;
    CardView card5;
    CardView card6;
    CardView card7;
    CardView card8;
    CardView card9;
    CardView logincard;
    private TextView textUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // deklarasi sessionmanagement supaya dikenali di kelas ini
        final SessionManagement sessionManagement;
        sessionManagement = new SessionManagement(activity_home.this);
        textUser = (TextView) findViewById(R.id.textUser);


        logincard = (CardView) findViewById(R.id.login);


        // mengecek apa yang dilakukan saat user telah login
        if(sessionManagement.isLoggedIn())
        {
            HashMap<String, String> loginUser = sessionManagement.getUserInformation();
            textUser.setText(loginUser.get(sessionManagement.KEY_USERNAME));

            //
            logincard.setVisibility(View.GONE);

        }

        logincard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),activity_login.class);
                startActivity(i);
                finish();
            }
        });

        ImageView img = (ImageView) findViewById(R.id.logout);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManagement.logoutUser();
            }
        });



        card1 = (CardView) findViewById(R.id.menu1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_acilgaluh.class);
                startActivity(i);
            }
        });

        card2 = (CardView) findViewById(R.id.menu2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_ronde.class);
                startActivity(i);
            }
        });

        card3 = (CardView) findViewById(R.id.menu3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_sate.class);
                startActivity(i);
            }
        });

        card4 = (CardView) findViewById(R.id.menu4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_hoklay.class);
                startActivity(i);
            }
        });

        card5 = (CardView) findViewById(R.id.menu5);
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_cairo.class);
                startActivity(i);
            }
        });

        card6 = (CardView) findViewById(R.id.menu6);
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_ceker.class);
                startActivity(i);
            }
        });

        card7 = (CardView) findViewById(R.id.menu7);
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_stmj.class);
                startActivity(i);
            }
        });

        card8 = (CardView) findViewById(R.id.menu8);
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_pecel.class);
                startActivity(i);
            }
        });

        card9 = (CardView) findViewById(R.id.menu9);
        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),detail_ketan.class);
                startActivity(i);
            }
        });

    }
}
