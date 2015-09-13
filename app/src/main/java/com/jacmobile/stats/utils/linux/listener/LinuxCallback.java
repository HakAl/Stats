package com.jacmobile.stats.utils.linux.listener;

import com.jacmobile.stats.utils.linux.entities.RunningProcess;

public interface LinuxCallback
{
    void onResult(RunningProcess runningProcess);
}
