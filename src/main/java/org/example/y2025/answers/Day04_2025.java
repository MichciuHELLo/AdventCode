package org.example.y2025.answers;

import org.example.DaterReader;
import org.example.Welcome;
import org.example.y2025.data.d04.ResultDay04;

import java.util.ArrayList;

public class Day04_2025 {

    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d04/Day04_2025_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d04/Day04_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");

        var inputStringList = DaterReader.getInputData(inputPath);

        int xLength = inputStringList.getFirst().length();
        int yLength = inputStringList.size();

        char[][] tab = new char[yLength][xLength];

        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                tab[y][x] = inputStringList.get(y).charAt(x);
            }
        }

        var result = solve(tab, xLength, yLength);

        System.out.println("=====================================");
        System.out.println("Ans Day02_2025_part1 = " + result.sum());
        System.out.println("=====================================");
    }

    public void part2() {
        Welcome.welcome("2025");

        var inputStringList = DaterReader.getInputData(inputPath);

        int xLength = inputStringList.getFirst().length();
        int yLength = inputStringList.size();

        char[][] tab = new char[yLength][xLength];

        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                tab[y][x] = inputStringList.get(y).charAt(x);
                System.out.print(tab[y][x]);
            }
            System.out.println();
        }
        System.out.println();

        ResultDay04 resultDay04;
        long result = 0;
        do {
            resultDay04 = solve(tab, xLength, yLength);
            tab = resultDay04.tab();
            result += resultDay04.sum();
        } while (resultDay04.sum() != 0);

        System.out.println("=====================================");
        System.out.println("Ans Day02_2025_part2 = " + result);
        System.out.println("=====================================");
    }

    private ResultDay04 solve(char[][] tab, int xLength, int yLength) {

        long sum = 0;
        int maxRollsOfPaper = 4;

        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {

                int rollsWithAccess = 0;
                boolean isRoll = false;

                if (tab[y][x] == '@') {
                    isRoll = true;

                    // check top
                    if (y != 0) {
                        if (x == 0) {
                            for (int k = x; k <= x + 1; k++) {
                                if (tab[y - 1][k] == '@') {
                                    rollsWithAccess++;
                                }
                            }
                        } else if (x == xLength - 1) {
                            for (int k = x - 1; k <= x; k++) {
                                if (tab[y - 1][k] == '@') {
                                    rollsWithAccess++;
                                }
                            }
                        } else {
                            for (int k = x - 1; k <= x + 1; k++) {
                                if (tab[y - 1][k] == '@') {
                                    rollsWithAccess++;
                                }
                            }
                        }
                    }

                    // check sides
                    if (x == 0) {
                        if (tab[y][x + 1] == '@') {
                            rollsWithAccess++;
                        }
                    } else if (x == xLength - 1) {
                        if (tab[y][x - 1] == '@') {
                            rollsWithAccess++;
                        }
                    } else {
                        if (tab[y][x + 1] == '@') {
                            rollsWithAccess++;
                        }
                        if (tab[y][x - 1] == '@') {
                            rollsWithAccess++;
                        }
                    }

                    // check bottom
                    if (y != yLength - 1) {
                        if (x == 0) {
                            for (int k = x; k <= x + 1; k++) {
                                if (tab[y + 1][k] == '@') {
                                    rollsWithAccess++;
                                }
                            }
                        } else if (x == xLength - 1) {
                            for (int k = x - 1; k <= x; k++) {
                                if (tab[y + 1][k] == '@') {
                                    rollsWithAccess++;
                                }
                            }
                        } else {
                            for (int k = x - 1; k <= x + 1; k++) {
                                if (tab[y + 1][k] == '@') {
                                    rollsWithAccess++;
                                }
                            }
                        }
                    }
                }

                if (rollsWithAccess < maxRollsOfPaper && isRoll) {
                    sum++;
                    System.out.print('X');

                    tab[y][x] = 'x';

                    yList.add(y);
                    xList.add(x);
                } else {
                    System.out.print(tab[y][x]);
                }

            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Remove " + sum + " rolls of paper:");
        System.out.println();

        for (int i = 0; i < xList.size(); i++) {
            System.out.println("y: " + yList.get(i) + " | x: " + xList.get(i));
        }
        System.out.println();

        return new ResultDay04(tab, sum);
    }
}
