package org.example.y2025.answers;

import org.example.Welcome;
import org.example.DaterReader;

import java.util.ArrayList;
import java.util.List;

public class Day01_2025 {

    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d01/Day01_2025_part1_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d01/Day1_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);

        int basePos = 50;
        int sum = 0;

        for (String currentLine : inputStringList) {
            char side = currentLine.charAt(0);
            int moves = Integer.parseInt(currentLine.substring(1));
            System.out.print(side + " " + moves);

            if (side == 'L') {
                basePos -= moves;
                if (basePos < 0) {
                    int hundreds = Math.abs(basePos / 100);
//                    System.out.println();
//                    System.out.println("hundreds: " + hundreds);
//                    System.out.print("100 + (" + basePos + " + " + hundreds + " * 100)");
                    basePos = 100 + (basePos + hundreds * 100);
                    if (basePos == 100)
                        basePos = 0;
                }
//                System.out.println(" = " + basePos);
            }

            else if (side == 'R') {
                basePos += moves;
                if (basePos > 99) {
                    int hundreds = basePos / 100;
                    basePos -= hundreds * 100;
                }
//                System.out.println(" - " + basePos);
            }

            System.out.println(" - " + basePos);

            if (basePos == 0) {
                sum++;
            }

        }

        System.out.println("=====================================");
        System.out.println("Ans Day01_2025_part1 = " + sum);
        System.out.println("=====================================");
    }

    public void part2() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);

        int basePos = 50;
        int sum = 0;

        System.out.println("Start position: 50");
        for (String currentLine : inputStringList) {
            char side = currentLine.charAt(0);
            int moves = Integer.parseInt(currentLine.substring(1));
            System.out.print(side + " " + moves);

            int startPos = basePos;
            if (side == 'L') {
                basePos -= moves;
                if (basePos < 0) {
                    int hundreds = Math.abs(basePos / 100);
                    int zerosTouched = (int) Math.ceil(Math.abs((double) basePos / 100));
                    basePos = 100 + (basePos + hundreds * 100);
                    sum += zerosTouched;
                    if (startPos == 0) {
                        sum--;
                    }
                    if (basePos == 100)
                        basePos = 0;
                }
                System.out.print(" = " + basePos);
            }

            else if (side == 'R') {
                basePos += moves;
                if (basePos > 99) {
                    int hundreds = basePos / 100;
                    sum += hundreds;
                    basePos -= hundreds * 100;
                    if (basePos == 0) {
                        sum--;
                    }
                }
                System.out.print(" = " + basePos);
            }

            if (basePos == 0) {
                sum++;
            }

            System.out.println(" | " + sum);
//            System.out.println();

        }

        System.out.println("=====================================");
        System.out.println("Ans Day01_2025_part2 = " + sum);
        System.out.println("=====================================");
    }

}
