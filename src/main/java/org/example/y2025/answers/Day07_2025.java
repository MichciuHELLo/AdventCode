package org.example.y2025.answers;

import org.example.DaterReader;
import org.example.Welcome;

import java.util.*;

public class Day07_2025 {

    private final String day = "07";
    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d" + day + "/Day" + day + "_2025_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d" + day + "/Day" + day + "_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");
        System.out.println("--- Day 7: Laboratories ---");
        var inputStringList = DaterReader.getInputData(inputPath);

        long sum = 0;
        Set<Integer> streams = new HashSet<>();

        for (int y = 0; y < inputStringList.size(); y++) {
            String currentLine = inputStringList.get(y);
            System.out.println();

            for (int x = 0; x < currentLine.length(); x++) {

                if (!streams.contains(x) || currentLine.charAt(x) == '^') {
                    System.out.print(currentLine.charAt(x));
                } else {
                    System.out.print('|');
                }

                if (currentLine.charAt(x) == 'S') {
                    streams.add(x);
                } else if (currentLine.charAt(x) == '^' && streams.contains(x)) {
                    streams.add(x-1);
                    streams.add(x+1);
                    streams.remove(x);
                    sum++;
                }
            }
            System.out.println();
        }


        System.out.println("=====================================");
        System.out.println("Ans Day05_2025_part1 = " + sum);
        System.out.println("=====================================");
    }

    public void part2() {
        Welcome.welcome("2025");
        System.out.println("--- Day 7: Laboratories ---");
        var inputStringList = DaterReader.getInputData(inputPath);

        long sum = 0;

        System.out.println("=====================================");
        System.out.println("Ans Day05_2025_part2 = " + sum);
        System.out.println("=====================================");
    }
}
