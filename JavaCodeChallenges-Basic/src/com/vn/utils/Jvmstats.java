package com.vn.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import com.sun.management.OperatingSystemMXBean;

public class Jvmstats {
	public static void main(String[] args) {
		// Get the OperatingSystemMXBean
		OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

		// Get the MemoryMXBean
		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

		// Get JVM memory usage
		MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
		MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();

		// Convert bytes to megabytes
		long heapInitMB = heapMemoryUsage.getInit() / (1024 * 1024);
		long heapUsedMB = heapMemoryUsage.getUsed() / (1024 * 1024);
		long heapCommittedMB = heapMemoryUsage.getCommitted() / (1024 * 1024);
		long heapMaxMB = heapMemoryUsage.getMax() / (1024 * 1024);

		long nonHeapInitMB = nonHeapMemoryUsage.getInit() / (1024 * 1024);
		long nonHeapUsedMB = nonHeapMemoryUsage.getUsed() / (1024 * 1024);
		long nonHeapCommittedMB = nonHeapMemoryUsage.getCommitted() / (1024 * 1024);
		long nonHeapMaxMB = nonHeapMemoryUsage.getMax() / (1024 * 1024);

		// Print memory usage in MB
		System.out.println("Heap Memory Usage:" + "  Init: " + heapInitMB + " MB" + "  Used: " + heapUsedMB + " MB"
				+ "  Committed: " + heapCommittedMB + " MB" + "  Max: " + heapMaxMB + " MB");

		System.out.println("Non-Heap Memory Usage:" + "  Init: " + nonHeapInitMB + " MB" + "  Used: " + nonHeapUsedMB
				+ " MB" + "  Committed: " + nonHeapCommittedMB + " MB" + "  Max: " + nonHeapMaxMB + " MB");

		// Get CPU load
		double processCpuLoad = osBean.getProcessCpuLoad() * 100;
		double systemCpuLoad = osBean.getSystemCpuLoad() * 100;

		// Print CPU load
		System.out.println("CPU Load:" + "  Process CPU Load: " + processCpuLoad + " %" + "  System CPU Load: "
				+ systemCpuLoad + " %");

		// Get system memory usage
		long totalPhysicalMemorySizeGB = osBean.getTotalPhysicalMemorySize() / (1024 * 1024 * 1024);
		long freePhysicalMemorySizeGB = osBean.getFreePhysicalMemorySize() / (1024 * 1024 * 1024);
		long usedPhysicalMemorySizeGB = totalPhysicalMemorySizeGB - freePhysicalMemorySizeGB;

		// Print system memory usage in MB
		System.out.println("System Memory Usage:");
		System.out.println("  Total Physical Memory: " + totalPhysicalMemorySizeGB + " GB");
		System.out.println("  Free Physical Memory: " + freePhysicalMemorySizeGB + " GB");
		System.out.println("  Used Physical Memory: " + usedPhysicalMemorySizeGB + " GB");
	}
}
