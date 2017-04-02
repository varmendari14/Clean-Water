package com.example.otteramazement.clean_water;

import android.content.Intent;
import android.graphics.Typeface;
//import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * This class controls the google map
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //private GoogleApiClient mGoogleApiClient;
    //private Location mCurrentLocation;

// --Commented out by Inspection START (4/1/17, 8:37 PM):
//    private final int[] MAP_TYPES = { GoogleMap.MAP_TYPE_SATELLITE,
//            GoogleMap.MAP_TYPE_NORMAL,
//            GoogleMap.MAP_TYPE_HYBRID,
//            GoogleMap.MAP_TYPE_TERRAIN,
//            GoogleMap.MAP_TYPE_NONE };
// --Commented out by Inspection STOP (4/1/17, 8:37 PM)
    //private int curMapTypeIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts
        TextView title = (TextView) findViewById(R.id.map_title);
        title.setTypeface(font);



        //button functionality

        ImageView backButton = (ImageView) findViewById(R.id.map_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), WaterReportActivity.class);
                startActivity(backIntent);
            }
        });



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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Add a marker for each water source report
        List<WaterSourceReport> reportList = WaterReportList.waterSourceList;
        for (int i = 0; i < reportList.size(); i++) {
            String latLon = reportList.get(i).getLocation();
            String[] fields = latLon.split("-");
            int lat = Integer.parseInt(fields[0]);
            int lon = Integer.parseInt(fields[1]);
            LatLng reportLocation = new LatLng(lat, lon);

            MarkerOptions myMarker = new MarkerOptions();
            myMarker.position(reportLocation);
            myMarker.title("Reported by " + reportList.get(i).getReporter());
            myMarker.snippet(reportList.get(i).mapMarkerToString());
            mMap.addMarker(myMarker);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(reportLocation));
        }
    }
}
