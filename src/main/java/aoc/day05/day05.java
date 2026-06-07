package aoc.day05;

import aoc.util.Input;

import java.util.*;

public class day05 {
    public static void main(String[] args) {
        List<String> input = Input.lines(5);   // swap to Input.sampleLines(3) while debugging
        System.out.println("Part 1: " + part1(input));
        System.out.println("Part 2: " + part2(input));
    }

    static Object part1(List<String> input) {
        int total = 0;
        int cutoff = input.indexOf("");

        List<String> ranges = input.subList(0, cutoff);
        long[] available = input.subList(cutoff + 1, input.size()).stream().mapToLong(Long::valueOf).toArray();

        List<Range> fresh = new ArrayList<>();

        for (String range : ranges) {
            String[] parts = range.split("-");
            fresh.add(new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])));
        }

        for (long ingredient : available) {
            for (Range range : fresh) {
                if (ingredient >= range.min && ingredient <= range.max) {
                    total++;
                    break;
                }
            }
        }

        return total;
    }

    static Object part2(List<String> input) {
        long total = 0;
        int cutoff = input.indexOf("");

        List<String> ranges = input.subList(0, cutoff);

        List<Range> fresh = new ArrayList<>();
        for (String range : ranges) {
            String[] parts = range.split("-");
            fresh.add(new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])));
        }

        while (!fresh.isEmpty()) {
            boolean done = true;
            Range range = fresh.removeLast();
            for (int i = 0; i < fresh.size(); i++) {
                Range compare = fresh.get(i);
                if (!(compare.max < range.min) && !(compare.min > range.max)) {
                    Range combined = new Range(Math.min(range.min, compare.min), Math.max(range.max, compare.max));
                    fresh.remove(i);
                    i--;
                    range = combined;
                    done = false;
                }
            }
            if(!done) {
                fresh.add(range);
            } else  {
                total+= range.max - range.min + 1;
            }
        }

        return total;
    }
}
