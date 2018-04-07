package cloudapp.cpumetrics;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public final class IcCpuMetrics {
    private IcCpuMetrics() {
    }

    private static Map<Long, IcTimeSampler> history = Collections
            .synchronizedMap(new HashMap<Long, IcTimeSampler>());
    private static volatile Long totalLiveHttpThreadsCpuTime = -1L;
    private static Timer timer = new Timer();

    private static void refreshtotalLiveHttpThreadsCpuTime() {
        if (totalLiveHttpThreadsCpuTime == -1) {
            final ThreadInfo[] tis = ManagementFactory.getThreadMXBean()
                    .dumpAllThreads(false, false);
            synchronized (totalLiveHttpThreadsCpuTime) {
                for (final ThreadInfo ti : tis)
                    if (ti.getThreadName().startsWith("qtp"))
                        totalLiveHttpThreadsCpuTime += ManagementFactory
                                .getThreadMXBean()
                                .getThreadCpuTime(ti.getThreadId());
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        totalLiveHttpThreadsCpuTime = -1l;
                    }
                }, 1000); // In order to prohibit recalculation each time, we
                // refresh it every 100 milliseconds if necessary.
            }
            IcTimeSampler data = history.get(-1l);
            if (data == null)
                data = new IcTimeSampler();
            data.cumulativeTime += totalLiveHttpThreadsCpuTime;
            data.sampleCount++;
            history.put(-1l, data);
        }
    }

    private static void updateThreadCpuTime(final long threadId,
                                            final long threadCpuTime) {
        IcTimeSampler data = history.get(threadId);
        if (data == null)
            data = new IcTimeSampler();
        data.cumulativeTime += threadCpuTime;
        data.sampleCount++;
        history.put(threadId, data);
    }

    public static void resetHistory(final long threadId) {
        IcTimeSampler data = history.get(threadId);
        if (data == null)
            data = new IcTimeSampler();
        data.cumulativeTime = 0;
        data.sampleCount = 0;
        history.put(threadId, data);
    }

    public static double getCurrentThreadCpuRateAmongLiveHttpThreads() {
        final long threadCpuTime = ManagementFactory.getThreadMXBean()
                .getCurrentThreadUserTime();

        updateThreadCpuTime(Thread.currentThread().getId(), threadCpuTime);
        refreshtotalLiveHttpThreadsCpuTime();
        return (double) threadCpuTime / (double) totalLiveHttpThreadsCpuTime;
    }

    public static double getCurrentThreadCpuRateSince(final long epoch,
                                                      final int cpuCount) {
        final long threadCpuTime = ManagementFactory.getThreadMXBean()
                .getCurrentThreadUserTime();
        updateThreadCpuTime(Thread.currentThread().getId(), threadCpuTime);
        return (double) threadCpuTime / (double) (System.nanoTime() - epoch)
                / 1000000 / cpuCount;
    }

    // public static double getThreadCpuRateAverageAmongLiveHttpThreads() {
    // final long threadCpuTime = ManagementFactory.getThreadMXBean()
    // .getCurrentThreadUserTime();
    // updateThreadCpuTime(Thread.currentThread().getId(), threadCpuTime);
    // refreshtotalLiveHttpThreadsCpuTime();
    // final IcTimeSampler threadData = history
    // .get(Thread.currentThread().getId());
    // final IcTimeSampler liveHttpThreadsData = history.get(-1l);
    // return (double) threadData.cumulativeTime
    // / (double) threadData.sampleCount
    // / ((double) liveHttpThreadsData.cumulativeTime
    // / (double) liveHttpThreadsData.sampleCount);
    // }
    //
    // public static double getThreadCpuRateAverageSince(final long epoch,
    // final int cpuCount) {
    // final long threadCpuTime = ManagementFactory.getThreadMXBean()
    // .getCurrentThreadUserTime();
    // updateThreadCpuTime(Thread.currentThread().getId(), threadCpuTime);
    // final IcTimeSampler threadData = history
    // .get(Thread.currentThread().getId());
    // return (double) threadData.cumulativeTime
    // / (double) threadData.sampleCount
    // / (System.currentTimeMillis() - epoch) / 1000000 / cpuCount;
    // }

}