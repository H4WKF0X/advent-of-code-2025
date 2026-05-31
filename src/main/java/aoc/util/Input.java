package aoc.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/** Reads puzzle inputs from the top-level inputs/ directory. */
public final class Input {
    private static final Path DIR = Path.of("inputs");

    private Input() {}

    private static Path path(int day, boolean sample) {
        return DIR.resolve("day%02d%s.txt".formatted(day, sample ? "_sample" : ""));
    }

    // Whole-file and line-based access
    public static String text(int day)        { return read(path(day, false)); }
    public static String sampleText(int day)  { return read(path(day, true)); }
    public static List<String> lines(int day)       { return readLines(path(day, false)); }
    public static List<String> sampleLines(int day) { return readLines(path(day, true)); }

    /** Blocks separated by a blank line (common AoC shape). */
    public static List<String> groups(int day) {
        return Arrays.asList(text(day).strip().split("\\R\\R"));
    }

    /** One integer per line. */
    public static int[] ints(int day) {
        return lines(day).stream()
                .filter(s -> !s.isBlank())
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();
    }

    /** Grid of characters, row per line. */
    public static char[][] grid(int day) {
        return lines(day).stream().map(String::toCharArray).toArray(char[][]::new);
    }

    private static List<String> readLines(Path p) {
        try { return Files.readAllLines(p); }
        catch (IOException e) { throw new UncheckedIOException("Missing input: " + p.toAbsolutePath(), e); }
    }

    private static String read(Path p) {
        try { return Files.readString(p); }
        catch (IOException e) { throw new UncheckedIOException("Missing input: " + p.toAbsolutePath(), e); }
    }
}