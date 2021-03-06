package com.jacmobile.stats.ui.view_items;

import android.support.v4.app.Fragment;

import com.jacmobile.stats.ui.fragments.RunningProcessFragment;

public class StatsPagerItem
{
    private final String title;

    public StatsPagerItem(String title)
    {
        this.title = title;
    }

    public Fragment createFragment()
    {
        return RunningProcessFragment.newInstance(title);
    }

    public CharSequence getTitle()
    {
        return title;
    }
}