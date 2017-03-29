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

/**
 * This class makes it so the location can be recorded from the user
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

}
