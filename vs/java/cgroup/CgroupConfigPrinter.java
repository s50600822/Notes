import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class CgroupConfigPrinter {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Processor Count: " + availableProcessors);

        long totalMemoryBytes = Runtime.getRuntime().totalMemory();
        long freeMemoryBytes = Runtime.getRuntime().freeMemory();
        long maxMemoryBytes = Runtime.getRuntime().maxMemory();

        long totalMemoryMB = totalMemoryBytes / (1024 * 1024);
        long freeMemoryMB = freeMemoryBytes / (1024 * 1024);
        long maxMemoryMB = maxMemoryBytes / (1024 * 1024);

        System.out.println("Available Memory (Total): " + totalMemoryMB + " MB");
        System.out.println("Available Memory (Free): " + freeMemoryMB + " MB");
        System.out.println("Maximum Memory (Allocated): " + maxMemoryMB + " MB");

        OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        // deprecated in favor of getTotalMemorySize(), however new method is not avail on JDK8
        // keeps this so we can test against 8 and above
        long totalSystemMemoryBytes = osBean.getTotalPhysicalMemorySize();
        long totalSystemMemoryMB = totalSystemMemoryBytes / (1024 * 1024);
        System.out.println("Total System Memory: " + totalSystemMemoryMB + " MB");
    }
}
