package org.example.y2025.answers;

import org.example.DaterReader;
import org.example.Welcome;
import org.example.y2025.data.d08.CircuitDay08;

import java.util.*;

public class Day08_2025 {

    private final String day = "08";
    final String examplePathPart1 = "src/main/java/org/example/y2025/data/d" + day + "/Day" + day + "_2025_example.txt";
    final String inputPath = "src/main/java/org/example/y2025/data/d" + day + "/Day" + day + "_2025_input.txt";

    public void part1() {
        Welcome.welcome("2025");
        System.out.println("--- Day 8: Playground  ---");
        var inputStringList = DaterReader.getInputData(examplePathPart1);

        double lowest = 999999999.0;
        List<CircuitDay08> sortedCircuits = new ArrayList<>();

        for (int i = 0; i < inputStringList.size() - 1; i++) {
            String currentLine = inputStringList.get(i);
            var splitLine = currentLine.split(",");

            int x1 = Integer.parseInt(splitLine[0]);
            int y1 = Integer.parseInt(splitLine[1]);
            int z1 = Integer.parseInt(splitLine[2]);

            for (int j = i + 1; j < inputStringList.size(); j++) {

                String testLine = inputStringList.get(j);
//                System.out.print(currentLine + " <-> " + testLine + " = ");

                var splitTestLineLine = testLine.split(",");

                int x2 = Integer.parseInt(splitTestLineLine[0]);
                int y2 = Integer.parseInt(splitTestLineLine[1]);
                int z2 = Integer.parseInt(splitTestLineLine[2]);

                double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));

                sortedCircuits.add(new CircuitDay08(currentLine, testLine, distance));

                if (distance < lowest) {
                    lowest = distance;
                }

//                System.out.println(distance);
            }
//            System.out.println();
        }

        sortedCircuits.sort(Comparator.comparingDouble(CircuitDay08::distance));

        for (int i = 0; i < sortedCircuits.size(); i++) {
            System.out.println(i+1 + ". " + sortedCircuits.get(i).pointA() + "<->" + sortedCircuits.get(i).pointB());
        }

//        System.out.println("==================");
        List<Set<String>> circuits = new ArrayList<>();
        circuits.add(new HashSet<>(Set.of(sortedCircuits.getFirst().pointA(), sortedCircuits.getFirst().pointB())));
        System.out.println();

        System.out.println("1. " + sortedCircuits.getFirst().pointA() + " <-> " + sortedCircuits.getFirst().pointB());
        for (int i = 1; i < 10; i++) {
            CircuitDay08 currentCircuit = sortedCircuits.get(i);

//            System.out.println(currentCircuit);
//            System.out.println(circuits);
//            System.out.println();
            System.out.println(i+1 + ". " + currentCircuit.pointA() + " <-> " + currentCircuit.pointB());

            boolean junctionAdded = false;
            int addedToCircuit = 0;
            for (int j = 0; j < circuits.size(); j++) {
//                System.out.println(circuits.get(j));
                if (junctionAdded && circuits.get(j).contains(currentCircuit.pointA()) || junctionAdded && circuits.get(j).contains(currentCircuit.pointB())) { // merge Circuits
                    circuits.get(addedToCircuit).addAll(circuits.get(j));
//                    circuits.get(j).removeAll(); ???
                }
                if (circuits.get(j).contains(currentCircuit.pointA()) || circuits.get(j).contains(currentCircuit.pointB())) {
//                    System.out.println(" - true");
                    circuits.get(j).add(currentCircuit.pointA());
                    circuits.get(j).add(currentCircuit.pointB());
                    junctionAdded = true;
                    addedToCircuit = j;
                }
            }
            if (!junctionAdded) {
//                System.out.println(" - false");
                circuits.add(new HashSet<>(Set.of(sortedCircuits.get(i).pointA(), sortedCircuits.get(i).pointB())));
            }
        }
        System.out.println();

        System.out.println("!======!");
        for (int i = 0; i < circuits.size(); i++) {
            System.out.println(circuits.get(i));
        }
        System.out.println("!======!");
        System.out.println();

        long sum = 0;

        /*

        [
            [162,817,812, 425,690,689, 431,825,988, 346,949,466]            4
            [906,360,560, 805,96,715, 739,650,466, 862,61,35, 984,92,344]   5
            [52,470,668, 117,168,530]                                       2
            [819,987,18, 941,993,340]                                       2
        ]

         */

        System.out.println("=====================================");
        System.out.println("Ans Day08_2025_part1 = " + sum);
        System.out.println("=====================================");
    }

    public void part2() {
        Welcome.welcome("2025");
        System.out.println("--- Day 7: Laboratories ---");
        var inputStringList = DaterReader.getInputData(examplePathPart1);

        long sum = 0;

        System.out.println("=====================================");
        System.out.println("Ans Day05_2025_part2 = " + sum);
        System.out.println("=====================================");
    }
}
