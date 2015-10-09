package com.jacmobile.stats.utils.linux;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.jacmobile.stats.utils.linux.entities.RunningProcess;
import com.jacmobile.stats.utils.linux.listener.LinuxCallback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class LinuxProcessHelper
{
    private static final String TAG = LinuxProcessHelper.class.getSimpleName();
    private static final String EXCEPTION = TAG + " EXCEPTION";

    private static final String HD = "/system/bin/hd";
    private static final String NETSTAT = "/system/bin/netstat";
    private static final String PRINTENV  = "/system/bin/printenv";
    private static final String PS = "/system/bin/ps";

//    public static final String TOP = "/system/bin/top/cat";
//    public static final String VMSTAT = "/system/bin/vmstat";

//    ArrayList<String> commandLine = new ArrayList<String>();
//    commandLine.add("logcat");//$NON-NLS-1$
//    [...]
//
//    Process process = Runtime.getRuntime().exec(commandLine);
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

//    try {
//    Process process = Runtime.getRuntime().exec("top -n 1 -d 1");
//    BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//} catch (InterruptedException e) {
//    e.printStackTrace();
//}

    @Inject LinuxProcessHelper() {}

    public void ps(@NonNull LinuxCallback callback)
    {
        String result = runProcess(PS);
        callback.onResult(new RunningProcess(result));
    }

    private String netstat()
    {
        return runProcess(NETSTAT);
    }
    private String hd()
    {
        return runProcess(HD);
    }
    private String ps()
    {
        return runProcess(PS);
    }
    private String printenv()
    {
        return runProcess(PRINTENV);
    }

    private String runProcess(String which)
    {
        Process processes = getProcess(which);
        if (processes == null) return EXCEPTION;

        StringBuilder processOutput = new StringBuilder();
        try {
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

    @Nullable private Process getProcess(String which)
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