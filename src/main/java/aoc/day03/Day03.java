package aoc.day03;

import aoc.util.Input;

import java.util.List;

public class Day03 {
    public static void main(String[] args) {
        List<String> input = Input.lines(3);   // swap to Input.sampleLines(3) while debugging
        System.out.println("Part 1: " + part1(input));
        System.out.println("Part 2: " + part2(input));
    }

    static Object part1(List<String> input) {
        int total = 0;
        for (String line : input) {
            char biggestFirst = '0';
            char biggestSecond = '0';
            int firstIndex = 0;
            int index = 0;

            char[] bank = line.substring(0, line.length() - 1).toCharArray();
            for (char c : bank) {
                if (c > biggestFirst) {
                    biggestFirst = c;
                    firstIndex = index;
                }
                index++;
            }
            char[] remaining = line.substring(firstIndex + 1).toCharArray();
            for (char c : remaining) {
                if (c > biggestSecond) {
                    biggestSecond = c;
                }
            }
            int add = Integer.parseInt(biggestFirst + String.valueOf(biggestSecond));
            //System.out.println(add);
            total+=add;
        }
        return total;
    }

    static Object part2(List<String> input) {
        long total = 0;
        for (String line : input) {
            char[] output = new char[12];
            int lastIndex = -1;
            for (int i = 11; i >= 0; i--) {
                char[] remaining =  line.substring(lastIndex + 1, line.length() - i).toCharArray();
                int index = lastIndex + 1;
                for (char c : remaining) {
                    if (c > output[11-i]) {
                        output[11-i] = c;
                        lastIndex = index;
                    }
                    index++;
                }
            }
            long add = Long.parseLong(new String(output));
            System.out.println(add);
            total+=add;
        }
        return total;
    }
}
