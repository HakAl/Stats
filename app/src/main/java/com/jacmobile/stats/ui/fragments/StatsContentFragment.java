package com.jacmobile.stats.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jacmobile.stats.R;
import com.jacmobile.stats.app.App;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StatsContentFragment extends Fragment
{
    private static final String KEY_TITLE = "kt";

    /**
     * @param title
     * @return
     */
    public static StatsContentFragment newInstance(String title)
    {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(KEY_TITLE, title);
        StatsContentFragment fragment = new StatsContentFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override public void onAttach(Context context)
    {
        ((App) context.getApplicationContext()).getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        ListView listView = (ListView) inflater.inflate(R.layout.stats_list, container, false);
        setTitle(getArguments().getString(KEY_TITLE));

        return listView;
    }

    private void setTitle(String title)
    {
        if (title != null) {
        }
    }
}