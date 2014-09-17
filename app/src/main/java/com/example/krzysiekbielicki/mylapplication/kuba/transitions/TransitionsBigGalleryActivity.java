package com.example.krzysiekbielicki.mylapplication.kuba.transitions;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;

import com.example.krzysiekbielicki.mylapplication.R;

public class TransitionsBigGalleryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setEnterTransition(new Explode());
//        getWindow().setExitTransition(new Explode());
        getWindow().setAllowEnterTransitionOverlap(true);

        setContentView(R.layout.activity_transitions_b);
    }
}
