package com.jacmobile.stats.ui.view_items;

import com.jacmobile.stats.R;
import com.jacmobile.stats.utils.linux.entities.RunningProcess;

public class RunningProcessListItem extends StatsListItem
{
    public RunningProcess process;

    /**
     *
     * @param process
     */
    public RunningProcessListItem(RunningProcess process)
    {
        this.process = process;
        title = process.name;
        titleStringResId = R.id.txt_ps_title;
        layoutResId = R.layout.ps_stats;
    }
}
