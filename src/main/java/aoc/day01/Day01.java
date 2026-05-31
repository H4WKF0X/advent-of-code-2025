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
        int pointer = 50;
        int password = 0;

        for (String line : input) {
            int amount = Integer.parseInt(line.substring(1));
            if (line.charAt(0) == 'L'){
                if (amount > pointer) {
                    password += (int) Math.ceil((amount - pointer) / 100.0);
                    if(pointer == 0) password--;
                    //System.out.println();
                }
                pointer = Math.floorMod(pointer - amount, 100);
                //System.out.println("pointer: " + pointer);
            } else {
                if (amount > (100 - pointer)) {
                    password += (int) Math.ceil((amount - (100 - pointer)) / 100.0);
                    //System.out.println();
                }
                pointer = Math.floorMod(pointer + amount, 100);
                //System.out.println("pointer: " + pointer);
            }

            if (pointer == 0) password++;
        }
        return password;
    }
}