package com.arjanvlek.oxygenupdater.views;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.arjanvlek.oxygenupdater.ApplicationData;
import com.arjanvlek.oxygenupdater.R;
import com.arjanvlek.oxygenupdater.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;

/**
 * Sets support action bar and enables home up button on the toolbar
 *
 * @author Adhiraj Singh Chauhan (github.com/adhirajsinghchauhan)
 */
public abstract class SupportActionBarActivity extends AppCompatActivity {

	private ApplicationData applicationData;

	@Override
	public void setContentView(@LayoutRes int layoutResId) {
		super.setContentView(layoutResId);

		setupToolbar();
	}

	@Override
	public void setContentView(View view) {
		super.setContentView(view);

		setupToolbar();
	}

	@Override
	public void setContentView(View view, ViewGroup.LayoutParams params) {
		super.setContentView(view, params);

		setupToolbar();
	}

	private void setupToolbar() {
		// For Android 10's edge-to-edge UI support
		findViewById(android.R.id.content).getRootView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

		AppBarLayout appBar = findViewById(R.id.app_bar);
		// Gotta add padding to the AppBar so that the text isn't drawn behind the status bar,
		// thanks to enabling Android 10's edge-to-edge UI support
		appBar.setPadding(0, Utils.getStatusBarHeight(this), 0, 0);

		Toolbar toolbar = findViewById(R.id.toolbar);

		setSupportActionBar(toolbar);

		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	protected ApplicationData getApplicationData() {
		if (applicationData == null) {
			applicationData = (ApplicationData) getApplication();
		}
		return applicationData;
	}
}
