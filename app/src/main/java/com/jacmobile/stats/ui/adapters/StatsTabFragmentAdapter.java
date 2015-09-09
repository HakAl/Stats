package com.jacmobile.stats.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jacmobile.stats.ui.view_items.StatsPagerItem;

import java.util.List;

/**
 * Created by alex on 9/6/15.
 */
public class StatsTabFragmentAdapter extends FragmentPagerAdapter
{
    private List<StatsPagerItem> mTabs;

    public StatsTabFragmentAdapter(FragmentManager fm, List<StatsPagerItem> mTabs)
    {
        super(fm);
        this.mTabs = mTabs;
    }

    @Override public Fragment getItem(int i)
    {
        return mTabs.get(i).createFragment();
    }

    @Override public int getCount()
    {
        return mTabs.size();
    }

    @Override public CharSequence getPageTitle(int position)
    {
        return mTabs.get(position).getTitle();
    }
}