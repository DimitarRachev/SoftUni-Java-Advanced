package javaAdvanced.p03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class p08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] fixedMatrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            fixedMatrix [i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                fixedMatrix[i][j] = matrix[i][j];
            }
        }

        int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int wrong = matrix[coordinates[0]][coordinates[1]];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrong) {
                    fixedMatrix[i][j] = replaceWrongValie(i, j, matrix, wrong);
                }
            }
        }

        for (int i = 0; i < fixedMatrix.length; i++) {
            for (int j = 0; j < fixedMatrix[i].length; j++) {
                System.out.print(fixedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int replaceWrongValie(int i, int j, int[][] matrix, int wrong) {
        int sum = 0;
        if (i - 1 >= 0) {
            if (matrix[i - 1][j] != wrong) {
                sum += matrix[i - 1][j];
            }
        }
        if (i + 1 < matrix.length) {
            if (matrix[i + 1][j] != wrong) {
                sum += matrix[i + 1][j];
            }
        }
        if (j - 1 >= 0) {
            if (matrix[i][j - 1] != wrong) {
                sum += matrix[i][j - 1];
            }
        }
        if (j + 1 < matrix[i].length) {
            if (matrix[i][j + 1] != wrong) {
                sum += matrix[i][j + 1];
            }
        }

        return sum;
    }
}
