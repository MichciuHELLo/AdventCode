package org.example.y2025.answers;

import org.example.DaterReader;
import org.example.Welcome;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day06_2025 {

    private final String day = "06";
    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d" + day + "/Day" + day + "_2025_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d" + day + "/Day" + day + "_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);

        long sum = 0;

        int xLength = inputStringList.getFirst().length();
        int yLength = inputStringList.size();

        long[][] tab = new long[yLength][xLength];
        char[] operators = new char[xLength];

        String operatorLine = inputStringList.getLast();
        System.out.println(operatorLine);

        var splitOperatorLine = operatorLine.split(" ");
        xLength = 0;
        for (int i = 0; i < splitOperatorLine.length; i++) {
            if (!Objects.equals(splitOperatorLine[i], "")) {
                String operator = splitOperatorLine[i];
                operators[xLength] = operator.charAt(0);
                xLength++;
            }
        }
        System.out.println();

        for (int y = 0; y < yLength - 1; y++) {
            String currentLine = inputStringList.get(y);
            var splitCurrentLine = currentLine.split(" ");
            xLength = 0;
            for (int x = 0; x < splitCurrentLine.length; x++) {
                if (!Objects.equals(splitCurrentLine[x], "")) {
                    tab[y][xLength] = Long.parseLong(splitCurrentLine[x]);
                    System.out.println("y: " + y + ", x: " + xLength + " | " + tab[y][xLength] + " ");
                    xLength++;
                }
            }
            System.out.println();
        }

        for (int x = 0; x < xLength; x++) {
            long columnResult = 0;
            for (int y = 0; y < yLength - 1; y++) {

                switch (operators[x]) {
                    case '+':
                        columnResult += tab[y][x];
                        break;
                    case '*':
                        if (y == 0) {
                            columnResult = 1;
                        }
                        columnResult *= tab[y][x];
                        break;
                }
                System.out.print(tab[y][x] + " ");
                if (y != yLength - 2) {
                    System.out.print(" " + operators[x] + " ");
                }
            }
            System.out.println("= " + columnResult);
            sum += columnResult;
        }

        System.out.println("=====================================");
        System.out.println("Ans Day05_2025_part1 = " + sum);
        System.out.println("=====================================");
    }

    public void part2() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);

        long sum = 0;

        int xLength = inputStringList.getFirst().length();
        int yLength = inputStringList.size();

        String operatorLine = inputStringList.getLast();

        var splitOperatorLine = operatorLine.split(" ");
        char[] operators = new char[xLength];
        xLength = 0;
        for (int i = 0; i < splitOperatorLine.length; i++) {
            if (!Objects.equals(splitOperatorLine[i], "")) {
                String operator = splitOperatorLine[i];
                operators[xLength] = operator.charAt(0);
                xLength++;
            }
        }
        System.out.println();

        int longestLength = 0;
        for (int i = 0; i < inputStringList.size(); i++) {
            System.out.println(inputStringList.get(i));
            int length = inputStringList.get(i).length();
            if (length > longestLength) {
                longestLength = length;
            }
        }
        System.out.println("\nlongestLength: " + longestLength);
        System.out.println();

        List<Long> cephalopod = new ArrayList<>();
        long[][] tab = new long[yLength][xLength];

        int operatorIndex = 0;

        long columnResult = 0;
        for (int x = 0; x < longestLength; x++) {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < yLength - 1; y++) {
                char foundChar = inputStringList.get(y).charAt(x);
                System.out.println("y: " + y + ", x: " + x + " ->" + foundChar + "<-");

                sb.append(foundChar);

                if (x + 1 == inputStringList.get(y).length() && x + 1 < longestLength) {

                    inputStringList.set(y, inputStringList.get(y) + ' ');
                }
            }

            if (sb.toString().isBlank()) {
                System.out.println("/\\ BALNK /\\ ");
                System.out.println("-----------------");

                operatorIndex++;
                sum += columnResult;
                columnResult = 0;
            } else {
                String stringNumber = sb.toString().replace(" ", "");
                long number = Long.parseLong(stringNumber);
                System.out.print("number: " + number);

                switch (operators[operatorIndex]) {
                    case '+':
                        System.out.print(" + " + columnResult);
                        columnResult += number;
                        System.out.println(" = " + columnResult);
                        break;
                    case '*':
                        if (columnResult == 0) {
                            columnResult = 1;
                        }
                        System.out.print(" * " + columnResult);
                        columnResult *= number;
                        System.out.println(" = " + columnResult);
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();

        sum += columnResult;

        System.out.println("=====================================");
        System.out.println("Ans Day05_2025_part2 = " + sum);
        System.out.println("=====================================");
    }
}
