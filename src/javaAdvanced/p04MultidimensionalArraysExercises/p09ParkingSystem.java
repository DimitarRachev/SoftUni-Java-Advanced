package javaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] parking = new boolean[size[0]][size[1]];

        String input;

        while (!"stop".equals(input = scanner.nextLine())) {
            int entryRow = Integer.parseInt(input.split(" ")[0]);
            int targetRow = Integer.parseInt(input.split(" ")[1]);
            int targetCol = Integer.parseInt(input.split(" ")[2]);
            int stepCounter = Math.abs(targetRow - entryRow) + 1;

            if (parking[targetRow][targetCol] == false) {
                parking[targetRow][targetCol] = true;
                stepCounter += targetCol;
                System.out.println(stepCounter);
            } else {
                int[] nearest = calculateNearestParkingkSpot(targetRow, targetCol, parking);
                if (nearest == null) {
                    System.out.printf("Row %d full%n", targetRow);
                } else {
                    parking[nearest[0]][nearest[1]] = true;
                    stepCounter += nearest[1];
                    System.out.println(stepCounter);
                }
            }
        }
    }

    private static int[] calculateNearestParkingkSpot(int targetRow, int targetCol, boolean[][] parking) {
        int steps = 1;
        while (targetCol + steps < parking[0].length || targetCol - steps >= 1) {
            if (targetCol - steps >= 1 && parking[targetRow][targetCol - steps] == false) {
                return new int[]{targetRow, targetCol - steps};
            } else if (targetCol + steps < parking[0].length && parking[targetRow][targetCol + steps] == false) {
                return new int[]{targetRow, targetCol + steps};
            }
            steps++;
        }
        return null;
    }
}
