package com.example.lim.kulinermalang.maps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.lim.kulinermalang.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class maps_ketan extends FragmentActivity implements OnMapReadyCallback {

    //deklarasi variabel
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menampilkan konten detail yang terkait
        setContentView(R.layout.activity_maps_ketan);
        // memperoleh informasi dari SupportMapFragment dan mendapat pemberitahuan jika peta sudah siap digunakan
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    //metode ketika peta siap digunakan
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //menambah tanda dan menyesuaikan koordinat yang diingankan
        LatLng ketan = new LatLng(-7.8710178, 112.5237696);
        mMap.addMarker(new MarkerOptions().position(ketan).title("Pos Ketan Legenda 1967"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ketan));
    }
}
