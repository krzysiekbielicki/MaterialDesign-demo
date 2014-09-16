package com.example.krzysiekbielicki.mylapplication.kuba;

import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.krzysiekbielicki.mylapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class OutlinesActivity extends Activity {

    @InjectView(R.id.standard_button)
    View standardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_outlines);

        ButterKnife.inject(this);

        setupStandardButtonOutline();
    }

    private void setupStandardButtonOutline() {
        Outline roundRectOutline = new Outline();
        roundRectOutline.setRoundRect(0, 0, standardButton.getLayoutParams().width, standardButton.getLayoutParams().height, 20);

        standardButton.setOutline(roundRectOutline);
        standardButton.setClipToOutline(true);
    }
}
