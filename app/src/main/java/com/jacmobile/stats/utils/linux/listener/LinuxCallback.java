package com.jacmobile.stats.utils.linux.listener;

import com.jacmobile.stats.utils.linux.entities.PSResult;

public interface LinuxCallback
{
    void onResult(PSResult psResult);
}
