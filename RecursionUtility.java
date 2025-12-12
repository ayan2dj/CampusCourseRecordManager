package edu.ccrm.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class RecursionUtility {
    private RecursionUtility() {}

    public static long folderSize(Path root) throws IOException {
        final long[] total = {0L};
        Files.walk(root).filter(Files::isRegularFile).forEach(p -> {
            try { total[0] += Files.size(p); } catch (IOException ignored) { }
        });
        return total[0];
    }
}
