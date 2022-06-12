package javaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = arr[0];
        int c = arr[1];
        String[][] matrix = new String[r][];
        for (int i = 0; i < r; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        String line;

        while (!"END".equals(line = scanner.nextLine())) {
            String[] input = line.split(" ");
            if (input.length != 5 || !input[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            int r1 = Integer.parseInt(input[1]);
            int c1 = Integer.parseInt(input[2]);
            int r2 = Integer.parseInt(input[3]);
            int c2 = Integer.parseInt(input[4]);
            if (!indexIsValid(r1, r) || !indexIsValid(c1, c) || !indexIsValid(r2, r) || !indexIsValid(c2, c)) {
                System.out.println("Invalid input!");
                continue;
            }

            String tmp = matrix[r1][c1];
            matrix[r1][c1] = matrix[r2][c2];
            matrix[r2][c2] = tmp;

            printMatrix(matrix);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean indexIsValid(int i, int max) {
        return i >= 0 && i < max;
    }
}
