package com.example.krzysiekbielicki.mylapplication.kuba.transitions;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Pair;
import android.view.View;

import com.example.krzysiekbielicki.mylapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TransitionsSmallGalleryActivity extends Activity {

    @InjectView(R.id.imageSmall1)
    View smallImage1;

    @InjectView(R.id.imageSmall2)
    View smallImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setEnterTransition(new Explode());
        getWindow().setAllowExitTransitionOverlap(true);

        setContentView(R.layout.activity_transitions_a);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.bigGallery)
    void onBigGalleryButtonClick() {
        startActivity(new Intent(this, TransitionsBigGalleryActivity.class));
    }

    @OnClick(R.id.imagesPanel)
    void onImagesPanelClicked() {
        Intent intent = new Intent(this, TransitionsBigGalleryActivity.class);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(smallImage1, smallImage1.getViewName()), Pair.create(smallImage2, smallImage2.getViewName()));

        // or: options = ActivityOptions.makeSceneTransitionAnimation(this, smallImage1, smallImage1.getViewName());

        startActivity(intent, options.toBundle());
    }
}
