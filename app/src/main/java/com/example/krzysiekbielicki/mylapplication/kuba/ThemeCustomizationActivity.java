package com.example.krzysiekbielicki.mylapplication.kuba;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.krzysiekbielicki.mylapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ThemeCustomizationActivity extends Activity {
    @InjectView(R.id.progress_bar_horizontal)
    protected ProgressBar horizontalProgressBar;

    private final Runnable updateProgressAndScheduleNextRunnable = new Runnable() {
        @Override
        public void run() {
            horizontalProgressBar.setProgress((horizontalProgressBar.getProgress() + 33)
                    % horizontalProgressBar.getMax());

            horizontalProgressBar.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_theme_customization);

        ButterKnife.inject(this);

        startProgressBarAnimation();
    }

    private void startProgressBarAnimation() {
        updateProgressAndScheduleNextRunnable.run();
    }

    @OnClick(R.id.button)
    protected void onButtonClick() {
        startActionMode(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });
    }
}
