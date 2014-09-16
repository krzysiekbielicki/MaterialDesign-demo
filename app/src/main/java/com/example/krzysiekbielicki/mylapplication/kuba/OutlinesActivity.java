package com.example.krzysiekbielicki.mylapplication.kuba;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.krzysiekbielicki.mylapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

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

	@OnClick(R.id.round_button)
	void onRoundButtonClick(View button) {
		makeJump(button);
	}

	private void makeJump(final View view) {
		final int jumpHeight = 50;
		final int jumpDuration = 400;

		view.animate()
				.translationZ(jumpHeight)
				.setDuration(jumpDuration)
				.setInterpolator(new AccelerateDecelerateInterpolator())
				.setListener(new Animator.AnimatorListener() {


					@Override
					public void onAnimationEnd(Animator animator) {
						view.animate()
								.translationZ(0)
								.setDuration(jumpDuration)
								.setInterpolator(new AccelerateDecelerateInterpolator());
					}

					@Override
					public void onAnimationStart(Animator animator) {

					}

					@Override
					public void onAnimationCancel(Animator animator) {

					}

					@Override
					public void onAnimationRepeat(Animator animator) {

					}
				});
	}
}
