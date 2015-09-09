package com.jacmobile.stats.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;

import com.jacmobile.stats.R;
import com.jacmobile.stats.ui.StatsTabConfig;
import com.jacmobile.stats.ui.adapters.StatsTabFragmentAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StatsTabFragment extends Fragment
{
    public static final String LAUNCH_INDEX = "li";

    @Bind(R.id.tabs_stats) TabLayout tabLayout;
    @Bind(R.id.stats_viewpager) ViewPager viewPager;

    /**
     *
     * @param index
     * @return
     */
    public static StatsTabFragment newInstance(int index)
    {
        StatsTabFragment fragment = new StatsTabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(LAUNCH_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.stats_tabs, container, false);
    }

    // Get the ViewPager and set it's PagerAdapter so that it can display items
    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        viewPager.setAdapter(new StatsTabFragmentAdapter(getChildFragmentManager(),
                        StatsTabConfig.getStatsPagerItems(getActivity())));
        tabLayout.setupWithViewPager(viewPager);
        if (getArguments() != null) viewPager.setCurrentItem(getArguments().getInt(LAUNCH_INDEX));
    }
}