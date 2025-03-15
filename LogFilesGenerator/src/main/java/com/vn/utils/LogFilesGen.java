package com.vn.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogFilesGen {
    private static final Logger logger = LogManager.getLogger(LogFilesGen.class);

    public static void main(String[] args) throws InterruptedException {
    	String folderPath = "J:\\Workspace-2023\\LogFilesGesdfdsnerator\\logs\\archive"; // Change this to your target folder
        long maxAgeInMinutes = 5; // Change to 5 * 24 * 60 for 5 days
        String FileNamecontainsStr = "-PWPAdapterweqr324ffsdf";
        new FileCleanup().deleteOldFiles(folderPath,FileNamecontainsStr, maxAgeInMinutes);
    	
    	while (true) {
            logger.info("This is an info log message.");
            logger.warn("This is a warning message.");
            logger.error("This is an error message.");
            Thread.sleep(5000); // Log every 5 seconds
        }
    }
}
