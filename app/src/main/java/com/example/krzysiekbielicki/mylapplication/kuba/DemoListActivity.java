package com.example.krzysiekbielicki.mylapplication.kuba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.krzysiekbielicki.mylapplication.R;
import com.example.krzysiekbielicki.mylapplication.kuba.recyclerview.RecyclerViewActivity;

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

	@OnClick(R.id.demo_two_themes)
	protected void onDemoTwoThemesButtonClick() {
		startActivity(TwoThemesActivity.class);
	}

	@OnClick(R.id.demo_recycler_view)
	protected void onDemoRecyclerViewThemesButtonClick() {
		startActivity(RecyclerViewActivity.class);
	}

    @OnClick(R.id.demo_custom_layout_manager)
    protected void onDemoCustomLayoutManagerButtonClick() {
        startActivity(RecyclerViewActivity.createIntent(this, true, false));
    }

    @OnClick(R.id.demo_card_view)
    protected void onDemoCardViewButtonClick() {
        startActivity(RecyclerViewActivity.createIntent(this, false, true));
    }

    private void startActivity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
