package com.jacmobile.stats.ui;

import android.content.Context;

import com.jacmobile.stats.R;
import com.jacmobile.stats.ui.view_items.StatsPagerItem;

import java.util.ArrayList;
import java.util.List;

public class StatsTabConfig
{
    public static List<StatsPagerItem> getStatsPagerItems(Context context)
    {
        List<StatsPagerItem> tabs = new ArrayList<>();
        tabs.add(new StatsPagerItem(context.getString(R.string.tab_cpu)));
        tabs.add(new StatsPagerItem(context.getString(R.string.tab_network)));
        tabs.add(new StatsPagerItem(context.getString(R.string.tab_sensors)));
        return tabs;
    }
}