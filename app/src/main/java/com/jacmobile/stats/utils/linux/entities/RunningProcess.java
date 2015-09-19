package com.jacmobile.stats.utils.linux.entities;

/*
    USER     PID   PPID  VSIZE  RSS     WCHAN    PC         NAME
    root      1     0     720    432   ffffffff 00000000 S /init
    root      2     0     0      0     ffffffff 00000000 S kthreadd
 */

public class RunningProcess extends LinuxResult
{
    public String user;
    public String pid;
    public String ppid;
    public String vsize;
    public String rss;
    public String wchan;
    public String pc;
    public String name;

    public RunningProcess(String raw)
    {
        super(raw);
    }

    @Override public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RunningProcess that = (RunningProcess) o;

        return name.equals(that.name);
    }

    @Override public int hashCode()
    {
        return name.hashCode();
    }

    @Override public String toString()
    {
        return "{" +
                "user='" + user + '\'' +
                ", pid='" + pid + '\'' +
                ", ppid='" + ppid + '\'' +
                ", vsize='" + vsize + '\'' +
                ", rss='" + rss + '\'' +
                ", wchan='" + wchan + '\'' +
                ", pc='" + pc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}