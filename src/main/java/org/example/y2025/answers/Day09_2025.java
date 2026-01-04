package org.example.y2025.answers;

import org.example.DaterReader;
import org.example.Welcome;
import org.example.y2025.data.d08.CircuitDay08;
import org.example.y2025.data.d09.PointCoordinates;

import java.util.*;

public class Day09_2025 {

    private final String day = "09";
    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d" + day + "/Day" + day + "_2025_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d" + day + "/Day" + day + "_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");
        System.out.println("--- Day " + day + ": Movie Theater  ---");
        var inputStringList = DaterReader.getInputData(inputPath);
        long maxSqr = 0;

        for (int i = 0; i < inputStringList.size() - 1; i++) {
            String pointA = inputStringList.get(i);
            for (int j = 1; j < inputStringList.size(); j++) {
                String pointB = inputStringList.get(j);

                var splitA = pointA.split(",");
                var splitB = pointB.split(",");

                long recLength = Math.abs(Integer.parseInt(splitA[0]) - Integer.parseInt(splitB[0])) + 1;
                long recHeight = Math.abs(Integer.parseInt(splitA[1]) - Integer.parseInt(splitB[1])) + 1;
                long recSquares = recLength * recHeight;

                System.out.println("A: " + pointA + ", B: " + pointB + ", Sqr = " + recSquares);

                if (maxSqr < recSquares) {
                    maxSqr = recSquares;
                }

            }
            System.out.println();
        }

        System.out.println("=====================================");
        System.out.println("Ans Day09_2025_part1 = " + maxSqr);
        System.out.println("=====================================");
    }

    public void part2() {
        Welcome.welcome("2025");
        System.out.println("--- Day 9: Movie Theater ---");
        var inputStringList = DaterReader.getInputData(inputPath);

        List<PointCoordinates> greenVertices = new ArrayList<>();

        int gridHeight = 0;
        int gridWidth = 0;

        for (String point : inputStringList) {
            var splitPoint = point.split(",");

            PointCoordinates pointCoordinates = new PointCoordinates(Integer.parseInt(splitPoint[0]), Integer.parseInt(splitPoint[1]));
            greenVertices.add(pointCoordinates);
            if (pointCoordinates.x() > gridWidth) gridWidth = pointCoordinates.x();
            if (pointCoordinates.y() > gridHeight) gridHeight = pointCoordinates.y();
        }

        gridHeight += 2;
        gridWidth += 2;

        greenVertices.sort((a, b) -> {
            if (a.y() != b.y()) {
                return Long.compare(a.y(), b.y()); // compare to first argument
            } else {
                return Long.compare(a.x(), b.x()); // if first is same → after second
            }
        });

        System.out.println("gridHeight: " + gridHeight);
        System.out.println("gridWidth: " + gridWidth);

        for (int i = 0; i < greenVertices.size(); i++) {
            System.out.println(greenVertices.get(i));
        }

        long sum = 0;

        System.out.println("=====================================");
        System.out.println("Ans Day09_2025_part2 = " + sum);
        System.out.println("=====================================");
    }
}
