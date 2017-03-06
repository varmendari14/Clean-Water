package com.example.otteramazement.clean_water;

import android.content.Intent;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Violet on 3/6/2017.
 */

public class LocationMapInputActivity extends FragmentActivity {

        private GoogleMap mMap;

        private GoogleApiClient mGoogleApiClient;
        private Location mCurrentLocation;

        private final int[] MAP_TYPES = { GoogleMap.MAP_TYPE_SATELLITE,
                GoogleMap.MAP_TYPE_NORMAL,
                GoogleMap.MAP_TYPE_HYBRID,
                GoogleMap.MAP_TYPE_TERRAIN,
                GoogleMap.MAP_TYPE_NONE };
        private int curMapTypeIndex = 0;

        UserProfile _user;

        public static final String ARG_USER = "user";

//        @Override
//        protected void onCreate(Bundle savedInstanceState) {

//            _user = (UserProfile) getIntent().getSerializableExtra(WaterAvailabilityActivity.ARG_USER);
//
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_maps);
//            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                    .findFragmentById(R.id.map);
//            mapFragment.getMapAsync(this);
//
//
//            Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
//            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");
//
//            //setting fonts
//            TextView title = (TextView) findViewById(R.id.map_title);
//            title.setTypeface(font);
//
//
//
//            //button functionalities
//
//            ImageView backButton = (ImageView) findViewById(R.id.map_backbutton_imageView);
//            backButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent backIntent = new Intent(getBaseContext(), WaterReportActivity.class);
//                    backIntent.putExtra(com.example.otteramazement.clean_water.MapsActivity.ARG_USER, _user);
//                    startActivity(backIntent);
//                }
//            });
//
//
//
//        }
//
//        @Override
//        public void onViewCreated(View view, Bundle savedInstanceState) {
//            super.onViewCreated(view, savedInstanceState);
//
//            setHasOptionsMenu(true);
//
//            mGoogleApiClient = new GoogleApiClient.Builder( getActivity() )
//                    .addConnectionCallbacks( this )
//                    .addOnConnectionFailedListener( this )
//                    .addApi( LocationServices.API )
//                    .build();
//
//            initListeners();
//        }
//
//        private void initListeners() {
//            getMap().setOnMarkerClickListener(this);
//            getMap().setOnMapLongClickListener(this);
//            getMap().setOnInfoWindowClickListener( this );
//            getMap().setOnMapClickListener(this);
//        }
//
//        @Override
//        public void onStart() {
//            super.onStart();
//            mGoogleApiClient.connect();
//        }
//
//        @Override
//        public void onStop() {
//            super.onStop();
//            if( mGoogleApiClient != null && mGoogleApiClient.isConnected() ) {
//                mGoogleApiClient.disconnect();
//            }
//        }
//
//        @Override
//        public void onConnected(Bundle bundle) {
//            mCurrentLocation = LocationServices
//                    .FusedLocationApi
//                    .getLastLocation( mGoogleApiClient );
//
//            initCamera( mCurrentLocation );
//        }
//
//        private void initCamera( Location location ) {
//            CameraPosition position = CameraPosition.builder()
//                    .target( new LatLng( location.getLatitude(),
//                            location.getLongitude() ) )
//                    .zoom( 16f )
//                    .bearing( 0.0f )
//                    .tilt( 0.0f )
//                    .build();
//
//            getMap().animateCamera( CameraUpdateFactory
//                    .newCameraPosition( position ), null );
//
//            getMap().setMapType( MAP_TYPES[curMapTypeIndex] );
//            getMap().setTrafficEnabled( true );
//            getMap().setMyLocationEnabled( true );
//            getMap().getUiSettings().setZoomControlsEnabled( true );
//        }
//
//        @Override
//        public void onMapClick(LatLng latLng) {
//
//            MarkerOptions options = new MarkerOptions().position( latLng );
//            options.title( getAddressFromLatLng( latLng ) );
//
//            options.icon( BitmapDescriptorFactory.defaultMarker() );
//            getMap().addMarker( options );
//        }
//
//    private String getAddressFromLatLng( LatLng latLng ) {
//        Geocoder geocoder = new Geocoder( getActivity() );
//
//        String address = "";
//        try {
//            address = geocoder
//                    .getFromLocation( latLng.latitude, latLng.longitude, 1 )
//                    .get( 0 ).getAddressLine( 0 );
//        } catch (IOException e ) {
//        }
//
//        return address;
//    }
//
//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        marker.showInfoWindow();
//        return true;
//    }

}
