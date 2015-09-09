package com.jacmobile.stats.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jacmobile.stats.R;
import com.jacmobile.stats.app.App;
import com.jacmobile.stats.ui.fragments.StatsTabFragment;

public class StatsActivity extends AppCompatActivity
{
    public static final String TAG = StatsActivity.class.getSimpleName();


    @Override protected void onCreate(Bundle savedInstanceState)
    {
        ((App)getApplicationContext()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stats);

        try {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.stats_content_fragment,
                            StatsTabFragment.newInstance(0))
                    .commit();
        } catch (Exception e) {
            log(e.toString());
        }
    }

    void log(String toLog)
    {
        Log.wtf(TAG, toLog);
    }
}
