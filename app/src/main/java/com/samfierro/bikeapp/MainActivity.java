package com.samfierro.bikeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.samfierro.bikeapp.MapsActivity;
import com.samfierro.bikeapp.R;

/**
 * Created by samfierro on 7/18/15.
 */
public class MainActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void enterApp() {

        Intent intent = new Intent(MainActivity.this,MapsActivity.class);
        startActivity(intent);

    }

    }

