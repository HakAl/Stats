package com.jacmobile.stats.utils.linux.parsers;

import com.jacmobile.stats.utils.linux.entities.RunningProcess;

public class RunningProcessParser
{
    public static void convert(String raw, RunningProcess result)
    {
        String[] array = raw.split("\\s+");
        if (array.length == 9) {
            result.user = array[0];
            result.pid = array[1];
            result.ppid = array[2];
            result.vsize = array[3];
            result.rss = array[4];
            result.wchan = array[5];
            result.pc = array[6];
            result.name = array[8];
        }
    }
}