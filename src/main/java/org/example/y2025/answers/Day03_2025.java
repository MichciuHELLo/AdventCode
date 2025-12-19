package org.example.y2025.answers;

import org.example.DaterReader;
import org.example.Welcome;

public class Day03_2025 {

    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d03/Day03_2025_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d03/Day03_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);

        long sum = 0;

        for (String currentLine : inputStringList) {

            System.out.println(currentLine);

            int topBattery = 0;
            for (int i = 0; i < currentLine.length() - 1; i++) {
                char currentBatA = currentLine.charAt(i);
                for (int j = i + 1; j < currentLine.length(); j++) {
                    char currentBatB = currentLine.charAt(j);
                    String buildBattery = String.valueOf(currentBatA) + currentBatB;

                    int currentBattery = Integer.parseInt(buildBattery);

                    if (currentBattery > topBattery) {
                        topBattery = currentBattery;
                    }
                }
            }
            sum += topBattery;
            System.out.println("Top battery: " + topBattery);
            System.out.println("sum: " + sum);
            System.out.println();
        }

        System.out.println("=====================================");
        System.out.println("Ans Day02_2025_part1 = " + sum);
        System.out.println("=====================================");
    }

    public void part2() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);

        long sum = 0;

        for (String currentLine : inputStringList) {

            System.out.println(currentLine);

            long topBattery = 0;
            int maxBatteries = 12;
            var sb = new StringBuilder();

            char firstBat = currentLine.charAt(0);
            sb.append(firstBat);
            System.out.println(sb);

            for (int j = 1; j < currentLine.length(); j++) {
                char nextBat = currentLine.charAt(j);
                int toTheEnd = currentLine.length() - j - 1;

                for (int i = 0; i < sb.length(); i++) {
                    if (nextBat > sb.charAt(i) && toTheEnd + i + 1 >= maxBatteries) {
                        sb.setCharAt(i, nextBat);
                        if (i + 1 < sb.length()) {
                            sb.delete(i+1, sb.length());
                        }
                    } else if (i == sb.length() - 1) {
                        if (sb.length() < maxBatteries) {
                            sb.append(nextBat);
                            break;
                        } else {
                            sb.setCharAt(i, nextBat);
                        }
                    }
                }
                System.out.println(sb);

                long currentBattery = Long.parseLong(sb.toString());
                if (currentBattery > topBattery) {
                    topBattery = currentBattery;
                }
            }
            sum += topBattery;
            System.out.println("Top battery: " + topBattery);
            System.out.println("sum: " + sum);
            System.out.println();
        }

        System.out.println("=====================================");
        System.out.println("Ans Day03_2025_part2 = " + sum);
        System.out.println("=====================================");
    }

}
