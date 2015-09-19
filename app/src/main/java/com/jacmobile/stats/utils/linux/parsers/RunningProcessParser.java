package com.jacmobile.stats.utils.linux.parsers;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.jacmobile.stats.utils.linux.entities.RunningProcess;

import java.util.ArrayList;
import java.util.List;

public class RunningProcessParser
{
    public static List<RunningProcess> parsePS(@NonNull String raw)
    {
        if (!TextUtils.isEmpty(raw)) {
            ArrayList<RunningProcess> results = new ArrayList<>(999);
            for (String string : raw.split("\n")) {
                results.add(convert(new RunningProcess(string)));
            }
            return results;
        }
        return new ArrayList<>();
    }

    private static RunningProcess convert(RunningProcess result)
    {
        String[] array = result.raw.split("\\s+");
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
        return result;
    }
}