package com.upb.mirestaurante;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upb.mirestaurante.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        // Add a marker in Sydney and move the camera

        LatLng medellin = new LatLng(6.221, -75.594);

        LatLng laureles = new LatLng(6.2546, -75.61);

        LatLng poblado = new LatLng(6.20, -75.57);

        LatLng itagui = new LatLng(6.17, -75.609);

        /*mMap.addMarker(new MarkerOptions().position(medellin).title("Marker in Medellin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(medellin));*/

        int height = 150;  // Altura deseada del ícono
        int width = 150;   // Anchura


        mMap.addMarker(new MarkerOptions()
                .position(medellin)
                .title("Sede Principal de Medellín")
                .snippet("Cra 65 N°45 - 85")
        );


        mMap.addMarker(new MarkerOptions()
                .position(poblado)
                .title("Sede de Poblado")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .alpha(0.6f)
                .snippet("Calle 10 N°43e - 135"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(poblado));

        mMap.addMarker(new MarkerOptions()
                .position(laureles)
                .title("Sede de Laureles")
                .alpha(0.6f)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                .snippet("Cra 81 N°37 - 100"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(laureles));

        mMap.addMarker(new MarkerOptions()
                .position(itagui)
                .title("Sede de Itagüi")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .alpha(0.5f)
                .snippet("Cl. 50 #47A-35"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(itagui));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin,10));

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }
}