package com.jacmobile.stats.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jacmobile.stats.R;
import com.jacmobile.stats.app.App;
import com.jacmobile.stats.ui.adapters.StatsListAdapter;
import com.jacmobile.stats.ui.view_items.StatsListItem;
import com.jacmobile.stats.utils.linux.LinuxProcessHelper;
import com.jacmobile.stats.utils.linux.entities.PSResult;
import com.jacmobile.stats.utils.linux.listener.LinuxCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StatsContentFragment extends Fragment
{
    private static final String KEY_TITLE = "kt";

    @Inject LinuxProcessHelper linuxProcessHelper;

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
        final ListView listView = (ListView) inflater.inflate(R.layout.stats_list, container, false);
        setTitle(getArguments().getString(KEY_TITLE));
        linuxProcessHelper.ps(new LinuxCallback() {
            @Override public void onResult(PSResult psResult)
            {
                StatsListItem[] items = new StatsListItem[1];
                StatsListItem listItem = new StatsListItem();
                listItem.title = psResult.raw;
                listItem.titleResId = R.id.txt_ps_title;
                listItem.viewResId = R.layout.ps_stats;
                items[0] = listItem;
                listView.setAdapter(new StatsListAdapter(Arrays.asList(items)));
            }
        });

        return listView;
    }

    private void setTitle(String title)
    {
        if (title != null) {
        }
    }
}