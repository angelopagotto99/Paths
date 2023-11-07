package com.example.paths;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.paths.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap myMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
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
    public void onMapReady(@NonNull GoogleMap googleMap) {

        myMap = googleMap;
        //myMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // Change to Satellite view

        String styleId="dc407dc9009f8b48";
        myMap.setMapStyle(new MapStyleOptions(styleId));

        myMap.getUiSettings().setZoomControlsEnabled(true); // Enable Zoom Controls
        myMap.getUiSettings().setCompassEnabled(true); // Enable Compass
        myMap.getUiSettings().setRotateGesturesEnabled(false); // Disable Rotate Gesture

        double countryLatitude=42.8333,countryLongitude=12.8333;
        LatLng countryCenter = new LatLng(countryLatitude, countryLongitude);
        float zoomLevel=5.0f;
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(countryCenter,zoomLevel));

        // Add a marker at a specific location
        LatLng treviso = new LatLng(45.6667, 12.2421);
        myMap.addMarker(new MarkerOptions().position(treviso).title("Treviso"));

        double startPointLatitude=45.6475,startPointLongitude=12.1286,endPointLatitude=45.6667,endPointLongitude=12.2421;
        PolylineOptions options = new PolylineOptions()
                .add(new LatLng(startPointLatitude, startPointLongitude))
                .add(new LatLng(endPointLatitude, endPointLongitude))
                .width(5)  // Set width of the line
                .color(Color.BLUE);  // Set color of the line

        myMap.addPolyline(options);

        myMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(@NonNull Marker marker) {
                // Return null to use default info window
                return null;
            }

            @Override
            public View getInfoContents(@NonNull Marker marker) {
                @SuppressLint("InflateParams") View infoWindow = getLayoutInflater().inflate(R.layout.custom_info_window, null);

                TextView title = infoWindow.findViewById(R.id.info_title);
                TextView snippet = infoWindow.findViewById(R.id.info_snippet);

                title.setText(marker.getTitle());
                snippet.setText(marker.getSnippet());

                return infoWindow;
            }
        });

    }

    // Getter and Setter for GoogleMap myMap
    public GoogleMap getMyMap() {
        return myMap;
    }

    public void setMyMap(GoogleMap myMap) {
        this.myMap = myMap;
    }

    // Getter and Setter for ActivityMapsBinding binding
    public ActivityMapsBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityMapsBinding binding) {
        this.binding = binding;
    }
}