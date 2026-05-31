package aoc.day01;

import aoc.util.Input;
import java.util.List;

public class Day01 {
    public static void main(String[] args) {
        List<String> input = Input.lines(1);   // swap to Input.sampleLines(1) while debugging
        System.out.println("Part 1: " + part1(input));
        System.out.println("Part 2: " + part2(input));
    }

    static Object part1(List<String> input) {
        int pointer = 50;
        int password = 0;

        for (String line : input) {
            if (line.charAt(0) == 'L'){
                pointer = (pointer - Integer.parseInt(line.substring(1)) + 100) % 100;
                //System.out.println("pointer: " + pointer);
            } else {
                pointer = (pointer + Integer.parseInt(line.substring(1)) + 100) % 100;
                //System.out.println("pointer: " + pointer);
            }

            if (pointer == 0) password++;
        }
        return password;
    }

    static Object part2(List<String> input) {
        return 0;
    }
}