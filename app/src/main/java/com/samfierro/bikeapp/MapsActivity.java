package com.samfierro.bikeapp;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
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
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
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

    private Marker b1b; private MarkerOptions bike1b;
    private Marker b10; private MarkerOptions bike10;
    private Marker b4; private MarkerOptions bike4;
    private Marker b3; private MarkerOptions bike3;
    private Marker bw; private MarkerOptions bikew;
    private Marker b1f; private MarkerOptions bike1f;

    private boolean isZooming = false;
    private float previousZoomLevel = -1.0f;
    private GroundOverlay g;

    private String infoString;
    Location currentLocation;
    LatLng loc;
    Marker markMarker;
    Marker millerMarker;
    Marker steveMarker;
    MarkerOptions setMark;
    MarkerOptions setMiller;
    MarkerOptions setSteve;
    private LatLng coordinate;
    String[] tokens;
    ArrayList<Marker> markerList = new ArrayList<Marker>();
    Date dateS;
    Date dateD;
    Date dateM;
    //HashMap<String,Marker> hm = new HashMap<String,Marker>();
    //Fragment f;
    String new_lat;
    String new_lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        g.setVisible(false);
        //Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();
    }

    public void standardBtn(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        g.setVisible(true);
    }

    public void hybridBtn(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        g.setVisible(false);
    }

    public void mark(View view) {
        if (markMarker != null) {markMarker.remove();}
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.NETWORK_PROVIDER;
        Location location = locationManager.getLastKnownLocation(provider);
        final double lat =  location.getLatitude();
        final double lng = location.getLongitude();
        coordinate = new LatLng(lat, lng);
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17.0f));
        if (location != null) {
            setMark = new MarkerOptions().position(coordinate);
            markMarker = mMap.addMarker(setMark);
            SupportMapFragment smf = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
            Fragment f = (MapsActivity.this.getSupportFragmentManager()).findFragmentById(R.id.map);
            mMap = smf.getMap();
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17.0f));
            f.setRetainInstance(true);
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
            //retrieve object by id
            query.getInBackground("mV9fHIS5HX", new GetCallback<ParseObject>() {
                public void done(ParseObject founderObject, com.parse.ParseException e) {
                    if (e == null) {
                        founderObject.put("Lat", "" + lat);
                        founderObject.put("Lon", "" + lng);
                        founderObject.saveInBackground();
                    }
                }
            });

            java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //get current date time with Date()
            dateD = new Date();
            System.out.println(dateFormat.format(dateD));

        }}

    public void miller(View view) {
        if (millerMarker != null) {millerMarker.remove();}
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.NETWORK_PROVIDER;
        Location location = locationManager.getLastKnownLocation(provider);
        final double lat =  location.getLatitude();
        final double lng = location.getLongitude();
        coordinate = new LatLng(lat, lng);
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17.0f));
        if (location != null) {
            setMiller = new MarkerOptions().position(coordinate);
            millerMarker = mMap.addMarker(setMiller);
            SupportMapFragment smf = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
            Fragment f = (MapsActivity.this.getSupportFragmentManager()).findFragmentById(R.id.map);
            mMap = smf.getMap();
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17.0f));
            f.setRetainInstance(true);
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
            //retrieve object by id
            query.getInBackground("IcQLyqVTXA", new GetCallback<ParseObject>() {
                public void done(ParseObject founderObject, com.parse.ParseException e) {
                    if (e == null) {
                        founderObject.put("Lat", "" + lat);
                        founderObject.put("Lon", "" + lng);
                        founderObject.saveInBackground();
                    }
                }
            });
            java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //get current date time with Date()
            dateM = new Date();
            System.out.println(dateFormat.format(dateM));
    }}

    public void steve(View view) {
        if (steveMarker != null) {steveMarker.remove();}
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.NETWORK_PROVIDER;
        Location location = locationManager.getLastKnownLocation(provider);
        final double lat =  location.getLatitude();
        final double lng = location.getLongitude();
        coordinate = new LatLng(lat, lng);
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17.0f));
        if (location != null) {
        setSteve = new MarkerOptions().position(coordinate);
        steveMarker = mMap.addMarker(setSteve);
            SupportMapFragment smf = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
            Fragment f = (MapsActivity.this.getSupportFragmentManager()).findFragmentById(R.id.map);
            mMap = smf.getMap();
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17.0f));
            f.setRetainInstance(true);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
        //retrieve object by id
        query.getInBackground("EDj7cM5Lw3", new GetCallback<ParseObject>() {
            public void done(ParseObject founderObject, com.parse.ParseException e) {
                if (e == null) {
                    founderObject.put("Lat", "" + lat);
                    founderObject.put("Lon", "" + lng);
                    founderObject.saveInBackground();
                }
            }
        });
            java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //get current date time with Date()
            dateS = new Date();
            System.out.println(dateFormat.format(dateS));
    }}

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
        //bldg 10 map overlay
        LatLng BLDG10 = new LatLng(33.127504, -117.265336);
        BldgMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.bldg))
                .position(BLDG10, 150f, 150f);
        g = mMap.addGroundOverlay(BldgMap);

        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.setMyLocationEnabled(true);
        Criteria criteria = new Criteria();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //String provider = locationManager.getBestProvider(criteria, false);
        String provider = LocationManager.NETWORK_PROVIDER;
        //if (locationManager.getLastKnownLocation(provider) != null){
        Location location = locationManager.getLastKnownLocation(provider);
        double lat =  location.getLatitude();
        double lng = location.getLongitude();
        coordinate = new LatLng(lat, lng);
        //starting location (current location) and zoom level
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17.0f));
        //built-in toolbar disabled
        mMap.getUiSettings().setMapToolbarEnabled(false);

        //adding bike markers
        bike1b = new  MarkerOptions()
                .position(new LatLng(33.126428, -117.267236))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bike));
        b1b = mMap.addMarker(bike1b);

        bike1f = new  MarkerOptions()
                .position(new LatLng(33.126867, -117.266892))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bike));
        b1f = mMap.addMarker(bike1f);

        bike10 = new  MarkerOptions()
                .position(new LatLng(33.127355, -117.265112))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bike));
        b10 = mMap.addMarker(bike10);

        bike3 = new  MarkerOptions()
                .position(new LatLng(33.125965, -117.268262))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bike));
        b3 = mMap.addMarker(bike3);

        bike4 = new  MarkerOptions()
                .position(new LatLng(33.126276, -117.268995))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bike));
        b4 = mMap.addMarker(bike4);

        bikew = new  MarkerOptions()
                .position(new LatLng(33.127205, -117.268572))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bike));
        bw = mMap.addMarker(bikew);


        //adding bldg markers
        marker1 = new MarkerOptions()
                .position(new LatLng(33.126959, -117.267231))
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
                .position(new LatLng(33.126019, -117.268828))
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

        if (markMarker == null) {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
            //retrieve object by id
            query.getInBackground("mV9fHIS5HX", new GetCallback<ParseObject>() {
                public void done(ParseObject founderObject, com.parse.ParseException e) {
                    if (e == null) {
                        new_lat = founderObject.getString("Lat");
                        new_lng = founderObject.getString("Lon");
                        founderObject.saveInBackground();
                        Double l = Double.parseDouble(new_lat);
                        Double n = Double.parseDouble(new_lng);
                        LatLng place = new LatLng(l,n);
                        setMark = new MarkerOptions().position(place);
                        markMarker = mMap.addMarker(setMark);
                        java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        //get current date time with Date()
                        dateD = new Date();
                        System.out.println(dateFormat.format(dateD));
                    }}
            });
        }

        if (millerMarker == null) {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
            //retrieve object by id
            query.getInBackground("IcQLyqVTXA", new GetCallback<ParseObject>() {
                public void done(ParseObject founderObject, com.parse.ParseException e) {
                    if (e == null) {
                        new_lat = founderObject.getString("Lat");
                        new_lng = founderObject.getString("Lon");
                        founderObject.saveInBackground();
                        Double l = Double.parseDouble(new_lat);
                        Double n = Double.parseDouble(new_lng);
                        LatLng place = new LatLng(l,n);
                        setMiller = new MarkerOptions().position(place);
                        millerMarker = mMap.addMarker(setMiller);
                        java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        //get current date time with Date()
                        dateM = new Date();
                        System.out.println(dateFormat.format(dateM));
                    }}
            });
        }

        if (steveMarker == null) {
            Toast.makeText(MapsActivity.this,"HEREEEEEEEEE",Toast.LENGTH_LONG).show();
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
            //retrieve object by id
            query.getInBackground("EDj7cM5Lw3", new GetCallback<ParseObject>() {
                public void done(ParseObject founderObject, com.parse.ParseException e) {
                    if (e == null) {
                        new_lat = founderObject.getString("Lat");
                        new_lng = founderObject.getString("Lon");
                        founderObject.saveInBackground();
                        Double l = Double.parseDouble(new_lat);
                        Double n = Double.parseDouble(new_lng);
                        LatLng place = new LatLng(l,n);
                        setSteve = new MarkerOptions().position(place);
                        steveMarker = mMap.addMarker(setSteve);
                        java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        //get current date time with Date()
                        dateS = new Date();
                        System.out.println(dateFormat.format(dateS));
                    }}
            });
        }

        markerList.add(b1f);
        markerList.add(b1b);
        markerList.add(b3);
        markerList.add(b4);
        markerList.add(b10);
        markerList.add(bw);

        new GetData().execute();
        //sets camera change listener
        mMap.setOnCameraChangeListener(getCameraChangeListener());
        //sets marker click listener
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker arg0) {
                //when a marker is clicked it gets data from server to update number of bikes
                new GetData().execute();

                b1f.setTitle("Bikes: ");
                b1b.setTitle("Bikes: ");
                b10.setTitle("Bikes: ");
                bw.setTitle("Bikes: ");
                b3.setTitle("Bikes: ");
                b4.setTitle("Bikes: ");

                final ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
                //retrieve object by id
                if (markMarker != null) {
                query.getInBackground("mV9fHIS5HX", new GetCallback<ParseObject>() {
                    public void done(ParseObject founderObject, com.parse.ParseException e) {
                        if (e == null) {
                            new_lat = founderObject.getString("Lat");
                            new_lng = founderObject.getString("Lon");
                            founderObject.saveInBackground();
                            Double l = Double.parseDouble(new_lat);
                            Double n = Double.parseDouble(new_lng);
                            LatLng place = new LatLng(l,n);
                            if (!(markMarker.getPosition().toString().equals(place.toString()))) {
                                markMarker.remove();
                                setMark = new MarkerOptions().position(place);
                                markMarker = mMap.addMarker(setMark);

                }
                        }}
                });
                    query.cancel();}
                final ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Founder");
                if (millerMarker != null) {
                    query2.getInBackground("IcQLyqVTXA", new GetCallback<ParseObject>() {
                        public void done(ParseObject founderObject, com.parse.ParseException e) {
                            if (e == null) {
                                new_lat = founderObject.getString("Lat");
                                new_lng = founderObject.getString("Lon");
                                founderObject.saveInBackground();
                                Double l = Double.parseDouble(new_lat);
                                Double n = Double.parseDouble(new_lng);
                                LatLng place = new LatLng(l, n);
                                if (!(millerMarker.getPosition().toString().equals(place.toString()))) {
                                    millerMarker.remove();
                                    setMiller = new MarkerOptions().position(place);
                                    millerMarker = mMap.addMarker(setMiller);

                                }
                            }
                        }
                    });
                    query2.cancel();
                }
                final ParseQuery<ParseObject> query3 = ParseQuery.getQuery("Founder");
                if (steveMarker != null) {
                query3.getInBackground("EDj7cM5Lw3", new GetCallback<ParseObject>() {
                    public void done(ParseObject founderObject, com.parse.ParseException e) {
                        if (e == null) {
                            new_lat = founderObject.getString("Lat");
                            new_lng = founderObject.getString("Lon");
                            founderObject.saveInBackground();
                            Double l = Double.parseDouble(new_lat);
                            Double n = Double.parseDouble(new_lng);
                            LatLng place = new LatLng(l,n);
                            if (!(steveMarker.getPosition().toString().equals(place.toString()))) {
                                steveMarker.remove();
                                setSteve = new MarkerOptions().position(place);
                                steveMarker = mMap.addMarker(setSteve);

                            }
                        }}
                });
                    query3.cancel();}

                if (markMarker != null) {
                    markMarker.setTitle("Spotted! Mark Dankberg");
                    markMarker.setSnippet(dateD.toString());}
                if (millerMarker != null) {
                    millerMarker.setTitle("Spotted! Mark Miller");
                    millerMarker.setSnippet(dateM.toString());}
                if (steveMarker != null) {
                    steveMarker.setTitle("Spotted! Steve Hart");
                    steveMarker.setSnippet(dateS.toString());}

                int i = 0;
                for (Marker marker : markerList) {
                    String str = tokens[i].substring(6);
                    if (str.charAt(0) == '0') {
                        str = str.substring(1);
                    }
                    marker.setTitle("Bikes: " + str);
                    i++;
                }

                String pos = arg0.getPosition().toString();
                switch (pos) {
                    case "lat/lng: (33.126428,-117.267236)":
                        b1b.showInfoWindow();
                        break;
                    case "lat/lng: (33.126867,-117.266892)":
                        b1f.showInfoWindow();
                        break;
                    case "lat/lng: (33.125965,-117.268262)":
                        b3.showInfoWindow();
                        break;
                    case "lat/lng: (33.126276,-117.268995)":
                        b4.showInfoWindow();
                        break;
                    case "lat/lng: (33.127355,-117.265112)":
                        b10.showInfoWindow();
                        break;
                    case "lat/lng: (33.127205,-117.268572)":
                        bw.showInfoWindow();
                        break;
                }

                String snip = arg0.getTitle();
                if (snip != null) {
                    switch (snip) {
                        case "Spotted! Mark Dankberg":
                            if (!markMarker.isInfoWindowShown()) {
                            markMarker.showInfoWindow();}
                            break;
                        case "Spotted! Mark Miller":
                            millerMarker.showInfoWindow();
                            break;
                        case "Spotted! Steve Hart":
                            steveMarker.showInfoWindow();
                            break;
                    }
                }

                String title = arg0.getTitle();
                if (title != null) {
                    switch (title) {
                        case "Bldg 1":
                            Intent intent = new Intent(MapsActivity.this,BldgOne.class);
                            startActivity(intent);
                            break;
                        case "Bldg 2":
                            Intent intent2 = new Intent(MapsActivity.this,BldgTwo.class);
                            startActivity(intent2);
                            break;
                        case "Bldg 3":
                            Intent intent3 = new Intent(MapsActivity.this,BldgThree.class);
                            startActivity(intent3);
                            break;
                        case "Bldg 4":
                            Intent intent4 = new Intent(MapsActivity.this,BldgFour.class);
                            startActivity(intent4);
                            break;
                        case "Bldg 5":
                            Intent intent5 = new Intent(MapsActivity.this,BldgFive.class);
                            startActivity(intent5);
                            break;
                        case "Bldg 6":
                            Intent intent6 = new Intent(MapsActivity.this,BldgSix.class);
                            startActivity(intent6);
                            break;
                        case "Bldg 6.5":
                            Intent intent65 = new Intent(MapsActivity.this,BldgSixFive.class);
                            startActivity(intent65);
                            break;
                        case "Bldg 7":
                            Intent intent7 = new Intent(MapsActivity.this,BldgSeven.class);
                            startActivity(intent7);
                            break;
                        case "Bldg 7.5":
                            Intent intent75 = new Intent(MapsActivity.this,BldgSevenFive.class);
                            startActivity(intent75);
                            break;
                        case "Bldg 8":
                            Intent intent8 = new Intent(MapsActivity.this,BldgEight.class);
                            startActivity(intent8);
                            break;
                        case "Bldg 9":
                            Intent intent9 = new Intent(MapsActivity.this,BldgNine.class);
                            startActivity(intent9);
                            break;
                        case "Bldg 10":
                            Intent intent10 = new Intent(MapsActivity.this,BldgTen.class);
                            startActivity(intent10);
                            break;
                    }
                }
                return true;
            }
        });
    }

    //If user zooms out past a certain level, bldg number icons disappear
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

    //class that gets string from server
    class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            // Client used to grab data from a provided URL
            DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
            // Provide the URL for the post request
            HttpPost httpPost = new HttpPost("http://10.11.242.32/index.php");
            // Define that the data expected is in JSON format
            httpPost.setHeader("Content-type", "text/xml");
            // Allows you to input a stream of bytes from the URL
            InputStream inputStream = null;
            try {
                // The client calls for the post request to execute and sends the results back
                HttpResponse response = httpClient.execute(httpPost);
                // Holds the message sent by the response
                HttpEntity entity = response.getEntity();
                // Get the content sent
                inputStream = entity.getContent();
                // A BufferedReader is used because it is efficient
                // The InputStreamReader converts the bytes into characters
                // My JSON data is UTF-8 so I read that encoding
                // 8 defines the input buffer size
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                // Storing each line of data in a StringBuilder
                StringBuilder sb = new StringBuilder();
                String line = null;
                // readLine reads all characters up to a \n and then stores them
                while((line = reader.readLine()) != null){
                    sb.append(line);
                }
                // Save the results to a String
                infoString = sb.toString();
                tokens = infoString.split("[\\s.,]+");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //
        }}

}
