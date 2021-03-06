package com.samfierro.bikeapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.samfierro.bikeapp.MapsActivity;
import com.samfierro.bikeapp.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by samfierro on 7/18/15.
 */
public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enable Local Datastore.

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "iWsUz0OqODCBHcKXETNtIyY21yrJAzSKa4BhKVXQ", "5xRSGufM1iVylXBC46hXIvi54lWpnYVRaqhGaQT0");

    }

    public void enterApp(View view) {
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
//        //retrieve object by id
//        query.getInBackground("IcQLyqVTXA", new GetCallback<ParseObject>() {
//            public void done(ParseObject founderObject, com.parse.ParseException e) {
//                if (e == null) {
//                    founderObject.put("Lat", "33.126782");
//                    founderObject.put("Lon", "-117.267966");
//                    founderObject.saveInBackground();
//                }}});
//                ParseQuery<ParseObject> query = ParseQuery.getQuery("Founder");
//        //retrieve object by id
//        query.getInBackground("mV9fHIS5HX", new GetCallback<ParseObject>() {
//            public void done(ParseObject founderObject, com.parse.ParseException e) {
//                if (e == null) {
//                    founderObject.put("Lat", "33.127193");
//                    founderObject.put("Lon", "-117.267320");
//                    founderObject.saveInBackground();
//                }}});

                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent);

                }}



