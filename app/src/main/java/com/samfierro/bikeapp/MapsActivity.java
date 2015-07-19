package com.samfierro.bikeapp;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Switch switchbtn;
    private GroundOverlayOptions BldgMap;
    private Marker m1; private MarkerOptions marker1;
    private Marker m2; private MarkerOptions marker2;
    private Marker m3; private MarkerOptions marker3;
    private Marker m4; private MarkerOptions marker4;
    private Marker m5; private MarkerOptions marker5;
    private Marker m6; private MarkerOptions marker6;
    private Marker m65; private MarkerOptions marker65;
    private Marker m7; private MarkerOptions marker7;
    private Marker m75; private MarkerOptions marker75;
    private Marker m8; private MarkerOptions marker8;
    private Marker m9; private MarkerOptions marker9;
    private Marker m10; private MarkerOptions marker10;

    private boolean isZooming = false;
    private float previousZoomLevel = -1.0f;
    private GroundOverlay g;
    private Button hybrid;
    private Button standard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        hybrid = (Button) findViewById(R.id.hybrid);
        g.setVisible(false);
        standard = (Button) findViewById(R.id.standard);

    }

    public void standardBtn(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        g.setVisible(true);
    }

    public void hybridBtn(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        g.setVisible(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        LatLng BLDG10 = new LatLng(33.127504, -117.265336);

        BldgMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.bldg))
                .position(BLDG10, 150f, 150f);
        g = mMap.addGroundOverlay(BldgMap);

        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.setMyLocationEnabled(true);
        Criteria criteria = new Criteria();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        double lat =  location.getLatitude();
        double lng = location.getLongitude();
        LatLng coordinate = new LatLng(lat, lng);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17.0f));

        mMap.getUiSettings().setMapToolbarEnabled(false);

        mMap.addMarker(new MarkerOptions()
                .snippet("Bike Rack")
                .position(new LatLng(33.126428, -117.267236))
                .title("Bikes: 1"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bike));
        mMap.addMarker(new MarkerOptions()
                .snippet("Bike Rack")
                .position(new LatLng(33.127376, -117.265137))
                .title("Bikes: 2"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bike));

        marker1 = new MarkerOptions()
                .position(new LatLng(33.126797, -117.267087))
                .title("Bldg 1")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.one));
        m1 = mMap.addMarker(marker1);

        marker2 = new MarkerOptions()
                .position(new LatLng(33.126782, -117.267966))
                .title("Bldg 2")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.two));
        m2 = mMap.addMarker(marker2);

        marker3 = new MarkerOptions()
                .position(new LatLng(33.126223, -117.267788))
                .title("Bldg 3")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.three));
        m3 = mMap.addMarker(marker3);

        marker4 = new MarkerOptions()
                .position(new LatLng(33.126306, -117.268821))
                .title("Bldg 4")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.four));
        m4 = mMap.addMarker(marker4);

        marker5 = new MarkerOptions()
                .position(new LatLng(33.125263, -117.267483))
                .title("Bldg 5")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.five));
        m5 = mMap.addMarker(marker5);

        marker6 = new MarkerOptions()
                .position(new LatLng(33.121532, -117.267901))
                .title("Bldg 6")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.six));
        m6 = mMap.addMarker(marker6);

        marker65 = new MarkerOptions()
                .position(new LatLng(33.124805, -117.268706))
                .title("Bldg 6.5")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sixfive));
        m65 = mMap.addMarker(marker65);

        marker7 = new MarkerOptions()
                .position(new LatLng(33.129421, -117.263599))
                .title("Bldg 7")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.seven));
        m7 = mMap.addMarker(marker7);

        marker75 = new MarkerOptions()
                .position(new LatLng(33.129619, -117.262483))
                .title("Bldg 7.5")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sevenfive));
        m75 = mMap.addMarker(marker75);

        marker8 = new MarkerOptions()
                .position(new LatLng(33.123842, -117.269050))
                .title("Bldg 8")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.eight));
        m8 = mMap.addMarker(marker8);

        marker9 = new MarkerOptions()
                .position(new LatLng(33.122422, -117.269447))
                .title("Bldg 9")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.nine));
        m9 = mMap.addMarker(marker9);

        marker10 = new MarkerOptions()
                .position(new LatLng(33.127607, -117.265595))
                .title("Bldg 10")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ten));
        m10 = mMap.addMarker(marker10);


        mMap.setOnCameraChangeListener(getCameraChangeListener());

    }

    public GoogleMap.OnCameraChangeListener getCameraChangeListener()
    {return new GoogleMap.OnCameraChangeListener()
        {
            @Override
            public void onCameraChange(CameraPosition position)
            {
                Log.d("Zoom", "Zoom: " + position.zoom);
                if(previousZoomLevel != position.zoom)
                {
                    isZooming = true;
                    //if ((position.zoom).compare(17.0f)) {
                    if ((new Float(position.zoom)).compareTo(new Float(17.0f)) < 0) {
                        m1.setVisible(false);
                        m2.setVisible(false);
                        m3.setVisible(false);
                        m4.setVisible(false);
                        m5.setVisible(false);
                        m6.setVisible(false);
                        m65.setVisible(false);
                        m7.setVisible(false);
                        m75.setVisible(false);
                        m8.setVisible(false);
                        m9.setVisible(false);
                        m10.setVisible(false);
                    } else {
                        m1.setVisible(true);
                        m2.setVisible(true);
                        m3.setVisible(true);
                        m4.setVisible(true);
                        m5.setVisible(true);
                        m6.setVisible(true);
                        m65.setVisible(true);
                        m7.setVisible(true);
                        m75.setVisible(true);
                        m8.setVisible(true);
                        m9.setVisible(true);
                        m10.setVisible(true);
                    }}
                previousZoomLevel = position.zoom;}};}

}
