package aoc.day02;

import aoc.util.Input;

import java.util.Arrays;
import java.util.List;

public class Day02 {
    public static void main(String[] args) {
        String input = Input.text(2);   // swap to Input.sampleLines(1) while debugging
        System.out.println("Part 1: " + part1(input));
        System.out.println("Part 2: " + part2(input));
    }

    static Object part1(String input) {
        List<String> ranges = Arrays.stream(input.split(",")).toList();

        long total = 0L;
        for(String range : ranges) {
            long lower = Long.parseLong(range.split("-")[0]);
            long upper = Long.parseLong(range.split("-")[1]);
            for(long i = lower; i <= upper; i++) {
                String numberStr = i + "";
                if (numberStr.length() % 2 == 0 && numberStr.substring(0, numberStr.length()/2).equals(numberStr.substring(numberStr.length()/2))) {
                    total += i;
                }
            }
        }
        return total;
    }

    static Object part2(String input) {
        return 0;
    }

}
