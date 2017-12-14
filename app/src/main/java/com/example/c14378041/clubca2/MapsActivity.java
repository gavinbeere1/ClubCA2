package com.example.c14378041.clubca2;

import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Date;

import static com.example.c14378041.clubca2.DBHandler.TABLE_CLUB;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    DBHandler dbHandler;
    DBHandler dbHandler2;
    private float x, y;
    private Location location;
    private LatLng latlng;
    Spinner dropdown;

    Location currentLocation = new Location("Curent Location - DIT");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        dbHandler = new DBHandler(this);
        dbHandler2 = new DBHandler(this);
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


        //
        Cursor cursor = dbHandler.getAllClubData();


//        ArrayList clubs = new ArrayList<Club>();

        while (cursor.moveToNext()) {
            // do what you need with the cursor here


            StringBuffer buffer = new StringBuffer();
            buffer.append("Id :" + cursor.getString(0) + "\n");
            int id = cursor.getInt(0);
            buffer.append("Name :" + cursor.getString(1) + "\n");
            String name = cursor.getString(1);

            buffer.append("Address :" + cursor.getString(2) + "\n");
            String address = cursor.getString(2);

            buffer.append("X :" + cursor.getString(3) + "\n");
            float x = cursor.getFloat(3);

            buffer.append("Y :" + cursor.getString(4) + "\n");
            float y = cursor.getFloat(4);


            buffer.append("Type :" + cursor.getString(5) + "\n\n");
            String type = cursor.getString(5);

            Intent intent = getIntent();
            String message = intent.getStringExtra(Welcome_Activity.EXTRA_MESSAGE);



            if(message.equals("GAA") && type.equals("GAA")) {

                LatLng latLongName;
                latLongName = new LatLng(x, y);
                mMap.addMarker(new MarkerOptions().position(latLongName).title(name).snippet(address).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            }
            else if(message.equals("Soccer") && type.equals("Soccer")) {

                LatLng latLongName;
                latLongName = new LatLng(x, y);
                mMap.addMarker(new MarkerOptions().position(latLongName).title(name).snippet(address));
            }
            if(message.equals("Rugby") && type.equals("Rugby")) {

                LatLng latLongName;
                latLongName = new LatLng(x, y);
                mMap.addMarker(new MarkerOptions().position(latLongName).title(name).snippet(address).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            }

        }




//        Location clannagaelGAA = new Location("Clan Na Gael GFC");
//        clannagaelGAA.setLatitude(53.3387645);
//        clannagaelGAA.setLongitude(-6.216584);
//
//
//        LatLng syngerGAA = new LatLng(53.3030601, -6.2943575);
//        LatLng clontarfGAA = new LatLng(53.3697547, -6.1844166);
//        LatLng vincentsGAA = new LatLng(53.374042, -6.2300634);
//        LatLng crokesGAA = new LatLng(53.2816864, -6.2212722);
//        LatLng ballymunGAA = new LatLng(53.4175189, -6.2664879);
//        mMap.addMarker(new MarkerOptions().position(clontarfGAA).title("Clontarf GFC").snippet("St.Annes Park, Clontarf").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
//        mMap.addMarker(new MarkerOptions().position(syngerGAA).title("Templeogue Synge Street GFC").snippet("Bushy Park, Templeogue Road, Terenure").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
//        mMap.addMarker(new MarkerOptions().position(vincentsGAA).title("St Vincents GFC").snippet("Malahide Road, Dublin").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
//        mMap.addMarker(new MarkerOptions().position(crokesGAA).title("Kilmacud Crokes GFC").snippet("82 Knocknashee, Goatstown").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
//        mMap.addMarker(new MarkerOptions().position(ballymunGAA).title("Ballymun Kickhams GFC").snippet("Collinstown Lane, Ballymun").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
//
//        LatLng clontarfFC = new LatLng(53.369615, -6.1859571);
//        LatLng homeFarmFC = new LatLng(53.3773174, -6.254601);
//        LatLng crumlinUtd = new LatLng(53.3239875, -6.3158361);
//        LatLng malahideUtd = new LatLng(53.4432719, -6.1290415);
//        LatLng haroldsCrossFC = new LatLng(53.3210205, -6.2833083);
//        mMap.addMarker(new MarkerOptions().position(clontarfFC).title("Clontarf FC").snippet("St.Annes Park, Clontarf"));
//        mMap.addMarker(new MarkerOptions().position(homeFarmFC).title("Home Farm FC").snippet("Swords Road, Whitehall"));
//        mMap.addMarker(new MarkerOptions().position(crumlinUtd).title("Crumlin Utd").snippet("177 Windmill Park, Crumlin"));
//        mMap.addMarker(new MarkerOptions().position(malahideUtd).title("Malahide Utd").snippet("Gannon Park, Coast Rd, Malahide"));
//        mMap.addMarker(new MarkerOptions().position(haroldsCrossFC).title("Harolds Cross FC").snippet("Rosary Park, Harolds Cross"));
//
//        LatLng deLaSalleRFC = new LatLng(53.248282, -6.206149);
//        LatLng stMarysRFC = new LatLng(53.302656, -6.3141024);
//        LatLng belvedreRFC = new LatLng(53.321502,-6.2308977);
//        LatLng lansdowneRFC = new LatLng(53.3334103,-6.2201649);
//        LatLng terenureRFC = new LatLng(53.3081565,-6.2962399);
//        mMap.addMarker(new MarkerOptions().position(deLaSalleRFC).title("De La Salle RFC").snippet("Enniskerry Road, Sandyford").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
//        mMap.addMarker(new MarkerOptions().position(stMarysRFC).title("St Marys College RFC").snippet("Templeville Road, Templeogue").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
//        mMap.addMarker(new MarkerOptions().position(belvedreRFC).title("Old Belvedre RFC").snippet("Ailesbury Grove, Ballsbridge").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
//        mMap.addMarker(new MarkerOptions().position(lansdowneRFC).title("Lansdowne RFC").snippet("Aviva Stadium, 62 Lansdowne Rd,").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
//        mMap.addMarker(new MarkerOptions().position(terenureRFC).title("Terenure RFC").snippet("Greenlea Grove, Terenure").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        //Translates locations into lon and lat in order to measure distant from current location to object

//        Location location = new Location("Templeogue Synge Street GFC");
//        location.setLatitude(syngerGAA.latitude);
//        location.setLongitude(syngerGAA.longitude);
//        location.setTime(new Date().getTime());


        LatLng dublin = new LatLng(53.3242381, -6.385785);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dublin, 10));



        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapsActivity.this));


        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                //mFusedLocationClient.getLastLocation() {
                //DB Code goes here
//for addubg yser ti clubs
                Cursor cursor = dbHandler.getAllClubUserData();



               // Cursor res = dbHandler.rawQuery("SELECT NAME FROM" + TABLE_CLUB + "WHERE NAME = " + marker.getTitle());
                String username = "Jerry";
               dbHandler.addClubUser(marker.getTitle(), username);

                currentLocation.setLatitude(53.3419322);
                currentLocation.setLongitude(-6.2670159);

                latlng = marker.getPosition();
                location = new Location(marker.getTitle());
                location.setLatitude(latlng.latitude);
                location.setLongitude(latlng.longitude);

                final float distance = currentLocation.distanceTo(location) / 1000;
                final String formattedDistance = String.format("%.02f", distance);




                boolean joinSuccessful = true;

                if (joinSuccessful = true) {
                    Toast.makeText(MapsActivity.this, "You've signed up for training, " + marker.getTitle() + " is " + formattedDistance + " KM away",
                            Toast.LENGTH_SHORT).show();
                }
//
//                    while (cursor.moveToNext()) {
//                        // do what you need with the cursor here
//
//
//
//                            StringBuffer buffer = new StringBuffer();
//                            buffer.append("Id :" + cursor.getString(0) + "\n");
//                            buffer.append("Name :" + cursor.getString(1) + "\n");
//                            buffer.append("Surname :" + cursor.getString(2) + "\n");
//
//                            // Show all data
//                            showMessage("Data", buffer.toString());
//
//
//
//
//
//
//                    }
//
//
//                }

            }
        });

    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void ButtonClick(View v) {
        Button button = (Button) v;

        Intent intent1 = new Intent(this, Welcome_Activity.class);
        startActivity(intent1);

    }}

