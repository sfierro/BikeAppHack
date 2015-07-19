package com.samfierro.bikeapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
//import com.imagezoom.ImageAttacher;
//import com.imagezoom.ImageAttacher.OnMatrixChangedListener;
//import com.imagezoom.ImageAttacher.OnPhotoTapListener;

import com.google.android.gms.maps.GoogleMap;
import com.imagezoom.ImageAttacher;

/**
 * Created by samfierro on 7/18/15.
 */
public class BldgEight extends Activity {

    //RelativeLayout layout;
    ImageView imageview;
    private ScaleGestureDetector gd;
    Matrix m = new Matrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        imageview = (ImageView) findViewById(R.id.imageview);

        Bitmap bimtBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.b8_f1);
        imageview.setImageBitmap(bimtBitmap);

        /**
         * Use Simple ImageView
         */
        usingSimpleImage(imageview);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        gd.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector){
            float scaleFactor = detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 0.8f));
            m.setScale(scaleFactor, scaleFactor);
            imageview.setImageMatrix(m);
            return true;
        }
    }

    public void floorOne(View view) {
        imageview.setImageResource(R.drawable.b8_f1);
        //layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.b1_f1));
    }

    public void floorTwo(View view) {
        imageview.setImageResource(R.drawable.b8_f2);
        //layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.b1_f2));
    }

    public void usingSimpleImage(ImageView imageView) {
        ImageAttacher mAttacher = new ImageAttacher(imageView);
        ImageAttacher.MAX_ZOOM = 2.0f; // Double the current Size
        ImageAttacher.MIN_ZOOM = 0.5f; // Half the current Size
        MatrixChangeListener mMaListener = new MatrixChangeListener();
        mAttacher.setOnMatrixChangeListener(mMaListener);
        PhotoTapListener mPhotoTap = new PhotoTapListener();
        mAttacher.setOnPhotoTapListener(mPhotoTap);
    }

    private class PhotoTapListener implements ImageAttacher.OnPhotoTapListener {

        @Override
        public void onPhotoTap(View view, float x, float y) {
        }
    }

    private class MatrixChangeListener implements ImageAttacher.OnMatrixChangedListener {

        @Override
        public void onMatrixChanged(RectF rect) {

        }
    }

}
