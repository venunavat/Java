package com.vn.utils;

    import java.io.File;
    import java.nio.file.Files;
    import java.nio.file.attribute.BasicFileAttributes;
    import java.time.Instant;
    import java.time.Duration;

    public class FileCleanup {
        public static void main(String[] args) {
            String folderPath = "J:\\Workspace-2023\\LogFilesGenerator\\logs\\archive"; // Change this to your folder path
            String searchString = "log"; // Change this to the substring you want to search for
            long olderThanMinutes = 5; // Set the time threshold in minutes
            //deleteOldFiles(folderPath, searchString, olderThanMinutes);
        }

        public void deleteOldFiles(String folderPath, String searchString, long minutes) {
            File folder = new File(folderPath);
            if (!folder.exists() || !folder.isDirectory()) {
                System.out.println("Invalid folder path.");
                return;
            }

            File[] files = folder.listFiles();
            if (files.length == 0) {
                System.out.println("No files found.");
                return;
            }

            Instant cutoffTime = Instant.now().minus(Duration.ofMinutes(minutes));

            for (File file : files) {
                if (file.isFile() && file.getName().contains(searchString)) {
                    try {
                        BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                        Instant fileCreationTime = attrs.creationTime().toInstant();

                        if (fileCreationTime.isBefore(cutoffTime)) {
                            if (file.delete()) {
                                System.out.println("Deleted: " + file.getName());
                            } else {
                                System.out.println("Failed to delete: " + file.getName());
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error processing file: " + file.getName() + " - " + e.getMessage());
                    }
                }
            }
        }
    }
