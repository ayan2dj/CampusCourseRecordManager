package edu.ccrm.config;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

public final class AppConfig {
    private static volatile AppConfig INSTANCE;

    private final Path projectRoot;
    private final Path exportDir;
    private final Path backupDir;
    private final Path testDataDir;
    private final int maxCreditsPerSemester;

    public static final DateTimeFormatter TS_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    private AppConfig() {
        this.projectRoot = Paths.get("").toAbsolutePath();
        this.exportDir = projectRoot.resolve("exported");
        this.backupDir = projectRoot.resolve("backups");
        this.testDataDir = projectRoot.resolve("test-data");
        this.maxCreditsPerSemester = 24;
        try {
            Files.createDirectories(exportDir);
            Files.createDirectories(backupDir);
            Files.createDirectories(testDataDir);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize directories", e);
        }
    }

    public static AppConfig getInstance() {
        if (INSTANCE == null) {
            synchronized (AppConfig.class) {
                if (INSTANCE == null) INSTANCE = new AppConfig();
            }
        }
        return INSTANCE;
    }

    public Path getProjectRoot() { return projectRoot; }
    public Path getExportDir() { return exportDir; }
    public Path getBackupDir() { return backupDir; }
    public Path getTestDataDir() { return testDataDir; }
    public int getMaxCreditsPerSemester() { return maxCreditsPerSemester; }
}
