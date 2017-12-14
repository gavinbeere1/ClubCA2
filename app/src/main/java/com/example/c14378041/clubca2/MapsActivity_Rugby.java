package com.example.c14378041.clubca2;

import android.content.Intent;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity_Rugby extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps__rugby);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Location currentLocation = new Location ("Curent Location - DIT");
        currentLocation.setLatitude(53.3419322);
        currentLocation.setLongitude(-6.2670159);
        Location clannagaelGAA = new Location("Clan Na Gael GFC");
        clannagaelGAA.setLatitude(53.3387645);
        clannagaelGAA.setLongitude(-6.216584);
        LatLng deLaSalleRFC = new LatLng(53.248282, -6.206149);
        LatLng stMarysRFC = new LatLng(53.302656, -6.3141024);
        LatLng belvedreRFC = new LatLng(53.321502,-6.2308977);
        LatLng lansdowneRFC = new LatLng(53.3334103,-6.2201649);
        LatLng terenureRFC = new LatLng(53.3081565,-6.2962399);
        mMap.addMarker(new MarkerOptions().position(deLaSalleRFC).title("De La Salle RFC").snippet("Enniskerry Road, Sandyford"));
        mMap.addMarker(new MarkerOptions().position(stMarysRFC).title("St Marys College RFC").snippet("Templeville Road, Templeogue"));
        mMap.addMarker(new MarkerOptions().position(belvedreRFC).title("Old Belvedre RFC").snippet("Ailesbury Grove, Ballsbridge"));
        mMap.addMarker(new MarkerOptions().position(lansdowneRFC).title("Lansdowne RFC").snippet("Aviva Stadium, 62 Lansdowne Rd,"));
        mMap.addMarker(new MarkerOptions().position(terenureRFC).title("Terenure RFC").snippet("Greenlea Grove, Terenure"));

        LatLng dublin = new LatLng(53.3242381,-6.385785);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dublin, 10));


        final float distance = currentLocation.distanceTo(clannagaelGAA)/1000;
        final String formattedDistance = String.format("%.02f", distance);


        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapsActivity_Rugby.this));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                //mFusedLocationClient.getLastLocation() {
                //DB Code goes here


                boolean joinSuccessful = true;

                if (joinSuccessful = true) {
                    Toast.makeText(MapsActivity_Rugby.this, "You've signed up for training, this club is " + formattedDistance + " KM away",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void ButtonClick(View v){
        Button button = (Button) v;

        Intent intent1 = new Intent(this, Welcome_Activity.class);
        startActivity(intent1);
    }
}

