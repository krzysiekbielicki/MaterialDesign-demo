package com.example.krzysiekbielicki.mylapplication.kuba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.krzysiekbielicki.mylapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemoListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_list);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.demo_hello)
    protected void onDemoHelloButtonClick() {
       startActivity(HelloMaterialDesignActivity.class);
    }

    @OnClick(R.id.demo_theme_customization)
    protected void onDemoThemeCustomizationButtonClick() {
        startActivity(ThemeCustomizationActivity.class);
    }

    private void startActivity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
