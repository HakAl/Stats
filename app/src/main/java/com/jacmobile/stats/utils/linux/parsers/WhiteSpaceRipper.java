package com.jacmobile.stats.utils.linux.parsers;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.jacmobile.stats.utils.linux.entities.RunningProcess;

import java.util.ArrayList;
import java.util.List;

public class WhiteSpaceRipper
{
    public static List<RunningProcess> ripString(@NonNull String raw)
    {
        if (!TextUtils.isEmpty(raw)) {
            ArrayList<RunningProcess> results = new ArrayList<>(999);
            for (String string : raw.split("\n")) {
                results.add(new RunningProcess(string));
            }
            return results;
        }
        return new ArrayList<>();
    }
}
