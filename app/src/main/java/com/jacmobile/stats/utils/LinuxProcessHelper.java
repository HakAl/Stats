package com.jacmobile.stats.utils;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinuxProcessHelper
{
    public static final String TAG = LinuxProcessHelper.class.getSimpleName();
    public static final String EXCEPTION = TAG + " EXCEPTION";

    public static final String HD = "/system/bin/hd";
    public static final String NETSTAT = "/system/bin/netstat";
    public static final String PRINTENV  = "/system/bin/printenv";
    public static final String PS = "/system/bin/ps";
//    public static final String TOP = "/system/bin/top";
//public static final String VMSTAT = "/system/bin/vmstat";



    public static String netstat()
    {
        return runProcess(NETSTAT);
    }
    public static String hd()
    {
        return runProcess(HD);
    }
    public static String ps()
    {
        return runProcess(PS);
    }
    public static String printenv()
    {
        return runProcess(PRINTENV);
    }


    private static String runProcess(String which)
    {
        Process processes = getProcess(which);
        if (processes == null) return EXCEPTION;

        StringBuilder processOutput = new StringBuilder();

        try  {
            BufferedReader processOutputReader = new BufferedReader(
                    new InputStreamReader(processes.getInputStream()));
            String readLine;
            while ((readLine = processOutputReader.readLine()) != null) {
                readLine = readLine + "\n";
                processOutput.append(readLine);
            }
            processes.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = processOutput.toString().trim();
        return TextUtils.isEmpty(result)
                ? EXCEPTION
                : result;
    }

    @Nullable private static Process getProcess(String which)
    {
        try {
            ProcessBuilder builder = new ProcessBuilder(which);
            builder.redirectErrorStream(true);
            return builder.start();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("IOException", TAG + "\n" + e.toString());
        }
        return null;
    }
}
