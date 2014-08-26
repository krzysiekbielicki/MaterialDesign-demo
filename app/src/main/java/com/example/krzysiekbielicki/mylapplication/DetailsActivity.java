package com.example.krzysiekbielicki.mylapplication;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Window;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_details);
    }
}
