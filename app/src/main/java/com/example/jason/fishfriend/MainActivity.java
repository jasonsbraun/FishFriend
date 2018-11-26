package com.example.jason.fishfriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Window;
import android.content.Intent;
import java.lang.*;
import java.util.*;
import java.lang.Object.*;

import com.google.firebase.auth.FirebaseAuth;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.maps.*;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.annotations.*;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.geojson.GeoJson;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, MapboxMap.OnMapClickListener {
    private MapView mapView;
    private FirebaseAuth mAuth;
    private Marker marker;
    private Button dropPin;
    private MapboxMap map;
    /*ArrayList<String[]> buoys = new ArrayList<String[]>();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*String[] tes ={"45.0000","-120.0000","Title","Windspeed","Temperature"};
        buoys.add(tes);*/
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mAuth = FirebaseAuth.getInstance();
        Mapbox.getInstance(this, "pk.eyJ1IjoiamFzb25zYnJhdW4iLCJhIjoiY2ptaWI4bHkzMDM1eTNxcWxpdzhxZDhkZCJ9.JoQJGtq9YXrufENaFLIbvg");
        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        dropPin = (Button)findViewById(R.id.addmarker);
        Button buttonclick = (Button)findViewById(R.id.signin_btn);
        buttonclick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent1);
            }
        });
        dropPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropPin.setEnabled(false);
                //Sends Data to database
            }
        });
    }
    @Override
    public void onMapReady(MapboxMap mapboxMap){
        map = mapboxMap;
        map.addOnMapClickListener(this);
        mapboxMap.addMarker(new MarkerOptions()
            .position(new LatLng(45, -90))
            .title("Test1"));
        mapboxMap.addMarker(new MarkerOptions()
            .position(new LatLng(45, -88))
            .title("Test2"));
        mapboxMap.addMarker(new MarkerOptions()
            .position(new LatLng(45, -86))
            .title("Test3"));
        /*int num = buoys.size();
        for(int x = 0;x<num;x++){
        String[] aBuoy = buoys.get(x);
        double lat = Double.parseDouble(aBuoy[0]);
        double lon = Double.parseDouble(aBuoy[1]);
        mapboxMap.addMarker(new MarkerOptions()
            .position(new LatLng(lat,lon))
            .title(aBuoy[2])
            .snippet(aBuoy[3]+aBuoy[4]));
        }*/
    }
    @Override
    public void onMapClick(@NonNull LatLng point){
        marker = map.addMarker(new MarkerOptions()
            .position(point));
        dropPin.setEnabled(true);
    }
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }
    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}

// if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED){
//   ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSION_ACCESS_COURSE_LOCATION );
//}

// LocationComponent locationComponent = mapboxMap.getLocationComponent();
//locationComponent.activateLocationComponent(this);
//  locationComponent.setLocationComponentEnabled(true);