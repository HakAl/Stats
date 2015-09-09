package com.jacmobile.stats.utils.linux.entities;

/*

    USER     PID   PPID  VSIZE  RSS     WCHAN    PC         NAME
    root      1     0     720    432   ffffffff 00000000 S /init
    root      2     0     0      0     ffffffff 00000000 S kthreadd
    root      3     2     0      0     ffffffff 00000000 S ksoftirqd/0
    root      4     2     0      0     ffffffff 00000000 S kworker/0:0
    root      5     2     0      0     ffffffff 00000000 S kworker/0:0H
    root      6     2     0      0     ffffffff 00000000 S kworker/u8:0
    root      7     2     0      0     ffffffff 00000000 S migration/0
    root      8     2     0      0     ffffffff 00000000 S rcu_preempt
    root      9     2     0      0     ffffffff 00000000 S rcu_bh
    root      10    2     0      0     ffffffff 00000000 S rcu_sched
    root      11    2     0      0     ffffffff 00000000 S migration/1
    root      12    2     0      0     ffffffff 00000000 S ksoftirqd/1
    root      13    2     0      0     ffffffff 00000000 S kworker/1:0
    root      14    2     0      0     ffffffff 00000000 S kworker/1:0H
    root      15    2     0      0     ffffffff 00000000 S migration/2
    root      16    2     0      0     ffffffff 00000000 S ksoftirqd/2
    root      17    2     0      0     ffffffff 00000000 S kworker/2:0
    root      18    2     0      0     ffffffff 00000000 S kworker/2:0H
    root      19    2     0      0     ffffffff 00000000 S migration/3
    root      20    2     0      0     ffffffff 00000000 S ksoftirqd/3
    root      21    2     0      0     ffffffff 00000000 S kworker/3:0
    root      22    2     0      0     ffffffff 00000000 S kworker/3:0H
    root      23    2     0      0     ffffffff 00000000 S khelper
    root      24    2     0      0     ffffffff 00000000 S writeback
    root      25    2     0      0     ffffffff 00000000 S kintegrityd
    root      26    2     0      0     ffffffff 00000000 S bioset
    root      27    2     0      0     ffffffff 00000000 S kblockd
    root      28    2     0      0     ffffffff 00000000 S ata_sff
    root      29    2     0      0     ffffffff 00000000 S khubd
    root      30    2     0      0     ffffffff 00000000 S kworker/2:1
    root      32    2     0      0     ffffffff 00000000 S kswapd0
    root      33    2     0      0     ffffffff 00000000 S ksmd
    root      34    2     0      0     ffffffff 00000000 S fsnotify_mark
    root      35    2     0      0     ffffffff 00000000 S crypto
    root      49    2     0      0     ffffffff 00000000 S kworker/u8:1
    root      50    2     0      0     ffffffff 00000000 S kworker/3:1
    root      51    2     0      0     ffffffff 00000000 S scsi_eh_0
    root      52    2     0      0     ffffffff 00000000 S scsi_eh_1
    root      53    2     0      0     ffffffff 00000000 S kworker/u8:2
    root      54    2     0      0     ffffffff 00000000 S kworker/0:1
    root      55    2     0      0     ffffffff 00000000 S dm_bufio_cache
    root      56    2     0      0     ffffffff 00000000 S binder
    root      57    2     0      0     ffffffff 00000000 S kworker/1:1
    root      58    2     0      0     ffffffff 00000000 S kworker/u8:3
    root      59    2     0      0     ffffffff 00000000 S kworker/u8:4
    root      60    2     0      0     ffffffff 00000000 S kworker/3:1H
    root      61    2     0      0     ffffffff 00000000 S kworker/2:1H
    root      62    2     0      0     ffffffff 00000000 S krfcommd
    root      63    2     0      0     ffffffff 00000000 S deferwq
    root      64    1     712    260   ffffffff 00000000 S /sbin/ueventd
    root      66    2     0      0     ffffffff 00000000 S kworker/0:1H
    root      67    2     0      0     ffffffff 00000000 S jbd2/sda6-8
    root      68    2     0      0     ffffffff 00000000 S ext4-dio-unwrit
    root      69    2     0      0     ffffffff 00000000 S jbd2/sdb1-8
    root      70    2     0      0     ffffffff 00000000 S ext4-dio-unwrit
    root      71    2     0      0     ffffffff 00000000 D jbd2/sdb3-8
    root      72    2     0      0     ffffffff 00000000 S ext4-dio-unwrit
    root      73    2     0      0     ffffffff 00000000 S iprt
    root      76    1     9496   2036  ffffffff 00000000 S /system/bin/genyd
    radio     77    1     1312   412   ffffffff 00000000 S /system/bin/logwrapper



 */



public class PSResult extends LinuxResult
{
    public String user;
    public String pid;
    public String ppid;
    public String vsize;
    public String rss;
    public String wchan;
    public String pc;
    public String name;

    public PSResult(String raw)
    {
        super(raw);
    }
}