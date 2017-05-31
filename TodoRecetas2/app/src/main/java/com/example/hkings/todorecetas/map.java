package com.example.hkings.todorecetas;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;


/**
 * A simple {@link Fragment} subclass.
 */



public class map extends Fragment{

    public map() {
        // Required empty public constructor
    }
    private GoogleMap mMap1;
    MapView mMapView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap1 = mMap;

                // For showing a move to my location button
                /*
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    mMap1.setMyLocationEnabled(true);
                } else {
                    Toast.makeText(getActivity(), "You have to accept to enjoy all app's services!", Toast.LENGTH_LONG).show();
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        mMap1.setMyLocationEnabled(true);
                    }
                }
                */


                // mMap1.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng medellin = new LatLng(6.2442, -75.5812);
                LatLng puertoberrio = new LatLng(6.477755, -74.80698129999996);
                LatLng barranquilla = new LatLng(11.0041072, -74.4088);
                LatLng bogota = new LatLng(4.598056, -74.075833);
                mMap1.addMarker(new MarkerOptions().position(medellin).title("Bandeja Paisa").snippet("40 minutos"));
                mMap1.addMarker(new MarkerOptions().position(puertoberrio).title("Boca Chico Frito").snippet("20 minutos"));
                mMap1.addMarker(new MarkerOptions().position(barranquilla).title("Arroz con coco").snippet("18 minutos"));
                mMap1.addMarker(new MarkerOptions().position(bogota).title("Ajiaco").snippet("90 minutos"));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(medellin).zoom(12).build();
                mMap1.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }













}
