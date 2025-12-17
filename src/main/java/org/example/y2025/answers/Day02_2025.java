package org.example.y2025.answers;

import org.example.DaterReader;
import org.example.Welcome;

import java.util.ArrayList;
import java.util.List;

public class Day02_2025 {

    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d02/Day01_2025_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d02/Day2_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");
        var inputStringList = DaterReader.getInputData(inputPath);

        long sum = 0;

        for (String currentLine : inputStringList) {
            var dividedLine = currentLine.split(",");

            for (int i = 0; i < dividedLine.length; i++) {
                System.out.println(dividedLine[i]);

                var dividedId = dividedLine[i].split("-");
                long startId = Long.parseLong(dividedId[0]);
                long endId = Long.parseLong(dividedId[1]);

                for (long j = startId; j <= endId; j++) {
                    int idLength = String.valueOf(j).length();
                    if (idLength % 2 == 0) {
                        int midId = idLength / 2;
                        String[] dividedCurrentId = {String.valueOf(j).substring(0, midId), String.valueOf(j).substring(midId)};
                        if (dividedCurrentId[0].equals(dividedCurrentId[1])) {
                            System.out.println("Invalid Id: " + j);
                            sum += j;
                            System.out.println("sum: " + sum);
                        }
                    }
                }
                System.out.println();
            }

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
            var dividedLine = currentLine.split(",");

            for (int i = 0; i < dividedLine.length; i++) {
                System.out.println(dividedLine[i]);

                var dividedId = dividedLine[i].split("-");
                long startId = Long.parseLong(dividedId[0]);
                long endId = Long.parseLong(dividedId[1]);

                for (long j = startId; j <= endId; j++) {
                    int idLength = String.valueOf(j).length();

                    for (int k = 2; k < 10; k++) {
                        if (idLength % k == 0) {
                            List<String> ids = new ArrayList<>();
                            int partLength = idLength / k;
                            for (int l = 0; l < idLength; l += partLength) {
                                String idPart = String.valueOf(j).substring(l, l + partLength);
                                ids.add(idPart);
                            }

                            boolean isEqual = true;
                            String firstIdPart = ids.getFirst();
                            for (int l = 1; l < ids.size(); l++) {
                                String testingIdPart = ids.get(l);
                                if (!firstIdPart.equals(testingIdPart)) {
                                    isEqual = false;
                                    break;
                                }
                            }

                            if (isEqual) {
                                System.out.println("Invalid Id: " + j);
                                sum += j;
                                System.out.println("sum: " + sum);
                                break;
                            }
                        }
                    }
                }
                System.out.println();
            }
        }

        System.out.println("=====================================");
        System.out.println("Ans Day01_2025_part2 = " + sum);
        System.out.println("=====================================");
    }

}
