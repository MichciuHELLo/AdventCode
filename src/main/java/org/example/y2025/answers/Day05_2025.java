package org.example.y2025.answers;

import org.example.DaterReader;
import org.example.Welcome;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day05_2025 {

    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d05/Day05_2025_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d05/Day05_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);

        int fresh = 0;

        boolean freshIdRanges = true;
        boolean availableIds = false;

        List<String> ranges = new ArrayList<>();

        for (String currentLine : inputStringList) {
            System.out.println(currentLine);

            if (availableIds) {
                long currentId = Long.parseLong(currentLine);

                for (int i = 0; i < ranges.size(); i++) {
                    String currentRanges = ranges.get(i);
                    var splitRanges = currentRanges.split("-");
                    long leftRange = Long.parseLong(splitRanges[0]);
                    long rightRange = Long.parseLong(splitRanges[1]);

                    if (leftRange <= currentId && currentId <= rightRange) {
                        fresh++;
                        System.out.println("Ingredient ID " + currentId + " is fresh because it falls into range " + currentRanges);
                        break;
                    }
                }
            }

            if (currentLine.isBlank()) {
                freshIdRanges = false;
                availableIds = true;
            }

            if (freshIdRanges) {
                ranges.add(currentLine);
            }
        }

        System.out.println("=====================================");
        System.out.println("Ans Day05_2025_part1 = " + fresh);
        System.out.println("=====================================");
    }

    public void part2() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);
        List<long[]> inputRanges = new ArrayList<>();

        boolean freshIdRanges = true;

        while (freshIdRanges) {

            System.out.println("-_ Input _-");
            for (int i = 0; i < inputStringList.size(); i++) {
                String currentLine = inputStringList.get(i);
                System.out.println(currentLine);

                if (currentLine.isBlank()) {
                    freshIdRanges = false;
                    break;
                }

                var splitRanges = currentLine.split("-");
                long leftRange = Long.parseLong(splitRanges[0]);
                long rightRange = Long.parseLong(splitRanges[1]);

                long[] tab = {leftRange, rightRange};

                inputRanges.add(tab);
            }
        }

        inputRanges.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]); // compare to first argument
            } else {
                return Long.compare(a[1], b[1]); // if first is same → after second
            }
        });

        System.out.println("-_ Sorted _-");
        for (long[] range : inputRanges) {
            System.out.println(range[0] + "-" + range[1]);
        }
        System.out.println();

        System.out.println("-_ Work in Progress _-");
        for (int i = 1; i < inputRanges.size(); i++) {
            long[] previousRange = inputRanges.get(i - 1);
            long leftPrev = previousRange[0];
            long rightPrev = previousRange[1];

            long[] currentRange = inputRanges.get(i);
            long leftCurr = currentRange[0];
            long rightCurr = currentRange[1];

            System.out.println(leftPrev + "-" + rightPrev);

            if (leftPrev <= leftCurr && leftCurr <= rightPrev) {
                if (rightCurr <= rightPrev) {
                    // range within - to delete
                    inputRanges.remove(i);
                    i--;
                } else {
                    previousRange[1] = rightCurr;
                    inputRanges.remove(i);
                    i--;
                }
            }
        }
        System.out.println();

        System.out.println("-_ Result _-");
        long sum = 0;
        int index = 0;
        for (long[] range : inputRanges) {
            index++;
            sum += range[1] - range[0] + 1;
            System.out.println(index + ". " + range[0] + "-" + range[1] + "    | sum: " + sum);
        }
        System.out.println();

        System.out.println("=====================================");
        System.out.println("Ans Day05_2025_part2 = " + sum);
        System.out.println("=====================================");
    }
}
