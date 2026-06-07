package aoc.day04;

import aoc.util.Input;

import java.util.List;

public class Day04 {
    public static void main(String[] args) {
        List<String> input = Input.lines(4);   // swap to Input.sampleLines(3) while debugging
        System.out.println("Part 1: " + part1(input));
        System.out.println("Part 2: " + part2(input));
    }

    static Object part1(List<String> input) {
        long total = 0;
        int[][] DIRS = {
                {0,-1}, {1,-1}, {1,0}, {1,1},
                {0,1}, {-1,1}, {-1,0}, {-1,-1}
        };

        char[][] grid = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            grid[i] = input.get(i).toCharArray();
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '@') {
                    int adjacent = 0;
                    for (int[] dir : DIRS) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '@') {
                            adjacent++;
                        }
                    }
                    if (adjacent < 4) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    static Object part2(List<String> input) {
        long total = 0;
        long totalChange = 0;
        int[][] DIRS = {
                {0,-1}, {1,-1}, {1,0}, {1,1},
                {0,1}, {-1,1}, {-1,0}, {-1,-1}
        };

        char[][] grid = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            grid[i] = input.get(i).toCharArray();
        }

        do {
            totalChange = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '@') {
                        int adjacent = 0;
                        for (int[] dir : DIRS) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '@') {
                                adjacent++;
                            }
                        }
                        if (adjacent < 4) {
                            total++;
                            totalChange++;
                            grid[i][j] = '.';
                        }
                    }
                }
            }
        } while (totalChange != 0);

        return total;
    }
}
