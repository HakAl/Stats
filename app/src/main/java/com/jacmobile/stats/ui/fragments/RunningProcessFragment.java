package com.jacmobile.stats.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.jacmobile.stats.R;
import com.jacmobile.stats.app.App;
import com.jacmobile.stats.ui.adapters.StatsListAdapter;
import com.jacmobile.stats.ui.view_items.RunningProcessListItem;
import com.jacmobile.stats.ui.view_items.StatsListItem;
import com.jacmobile.stats.utils.linux.LinuxProcessHelper;
import com.jacmobile.stats.utils.linux.entities.RunningProcess;
import com.jacmobile.stats.utils.linux.listener.LinuxCallback;
import com.jacmobile.stats.utils.linux.parsers.RunningProcessParser;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RunningProcessFragment extends Fragment
{
    public static final String KEY_TITLE = "kt";

    @Inject LinuxProcessHelper linuxProcessHelper;

    @Bind(R.id.stats_listview) ListView listView;
    @Bind(R.id.txt_ps_title) TextView psTitle;
    @Bind(R.id.txt_ps_subtitle) TextView psSubtitle;

    public static RunningProcessFragment newInstance(String title)
    {
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        RunningProcessFragment fragment = new RunningProcessFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onAttach(Context context)
    {
        ((App) context.getApplicationContext()).getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        final View view = inflater.inflate(R.layout.ps_snapshot, container, false);
        ButterKnife.bind(this, view);
        linuxProcessHelper.ps(new LinuxCallback()
        {
            @Override public void onResult(RunningProcess runningProcess)
            {
                updateView(runningProcess);
            }
        });
        return view;
    }

    private void updateView(RunningProcess runningProcess)
    {
        ArrayList<RunningProcess> r = new ArrayList<>(
                RunningProcessParser.parsePS(runningProcess.raw));
        r.remove(0);
        int size = r.size();
        StatsListItem[] items = new RunningProcessListItem[size];
        for (int i = 0; i < size; i++) {
            items[i] = new RunningProcessListItem(r.get(i));
        }
        listView.setAdapter(new StatsListAdapter(Arrays.asList(items)));
        psTitle.setText(String.format("Total Processes: %s", size));
        psSubtitle.setText("32%% Memory Capacity");
    }
    boolean[] result = {false};
    public boolean checkAndroidData()
   {
       new Handler().post(new Runnable()
       {
           @Override
           public void run()
           {
               // Android code here
               // I need know the value of this variable
               result[0] = true;
            }
        });
        return result[0];
    }
}