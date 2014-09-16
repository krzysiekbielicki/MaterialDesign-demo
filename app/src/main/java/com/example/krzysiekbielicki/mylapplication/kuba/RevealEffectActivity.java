package com.example.krzysiekbielicki.mylapplication.kuba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;

import com.example.krzysiekbielicki.mylapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RevealEffectActivity extends Activity {

	@InjectView(R.id.logIn)
	Button logInButton;

	@InjectView(R.id.loginPanel)
	View loginPanel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_reveal_effect);

		ButterKnife.inject(this);
	}

	@OnClick(R.id.logIn)
	void onLogInButtonClick() {
		hideLogInButtonAndShowPanel();
	}

	private void hideLogInButtonAndShowPanel() {
		int cx = (logInButton.getLeft() + logInButton.getRight()) / 2;
		int cy = logInButton.getBottom();

		// get the final radius for the clipping circle
		int initialRadius = logInButton.getWidth();

		// create and start the animator for this view
		// (the start radius is zero)
		ValueAnimator anim = ViewAnimationUtils.createCircularReveal(logInButton, cx, cy, initialRadius, 0);
		anim.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				logInButton.setVisibility(View.GONE);
				showLoginPanel();
			}
		});

		anim.setDuration(500).start();
	}

	private void showLoginPanel() {
		int cx = (loginPanel.getLeft() + loginPanel.getRight()) / 2;
		int cy = 0;

		// get the final radius for the clipping circle
		int finalRadius = loginPanel.getWidth();

		loginPanel.setVisibility(View.VISIBLE);

		// create and start the animator for this view
		// (the start radius is zero)
		ValueAnimator anim = ViewAnimationUtils.createCircularReveal(loginPanel, cx, cy, 0, finalRadius);
		anim.setDuration(500).start();
	}

	@OnClick(R.id.skip)
	void onSkipButtonClick() {
		hideLoginPanelAndShowButton();
	}

	private void hideLoginPanelAndShowButton() {
		int cx = (loginPanel.getLeft() + loginPanel.getRight()) / 2;
		int cy = loginPanel.getTop();

		// get the final radius for the clipping circle
		int initialRadius = loginPanel.getWidth();

		// create and start the animator for this view
		// (the start radius is zero)
		ValueAnimator anim = ViewAnimationUtils.createCircularReveal(loginPanel, cx, cy, initialRadius, 0);
		anim.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				loginPanel.setVisibility(View.INVISIBLE);
				showLogInButton();
			}
		});

		anim.setDuration(500).start();
	}

	private void showLogInButton() {
		int cx = (loginPanel.getLeft() + loginPanel.getRight()) / 2;
		int cy = 0;

		// get the final radius for the clipping circle
		int finalRadius = loginPanel.getWidth();

		logInButton.setVisibility(View.VISIBLE);

		// create and start the animator for this view
		// (the start radius is zero)
		ValueAnimator anim = ViewAnimationUtils.createCircularReveal(logInButton, cx, cy, 0, finalRadius);
		anim.setDuration(500).start();
	}
}
