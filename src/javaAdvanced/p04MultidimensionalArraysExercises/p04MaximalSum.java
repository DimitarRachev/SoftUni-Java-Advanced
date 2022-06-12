package javaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;
        int[][] maxMatrix = new int[3][3];
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {

                int sum = calculateSum(i, j, matrix);
                if (sum > maxSum) {
                    maxSum = sum;
                    maxMatrix = getMatrix(i, j, matrix);
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(maxMatrix);
    }

    private static int calculateSum(int i, int j, int[][] matrix) {
        int[][] temp = getMatrix(i, j, matrix);
        return Arrays.stream(temp)
                .map(e -> Arrays.stream(e).sum())
                .mapToInt(e -> e)
                .sum();
    }

    private static int[][] getMatrix(int i, int j, int[][] matrix) {
        int[][] newMatrix = new int[3][3];
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                newMatrix[k][l] = matrix[i + k][j + l];
            }
        }
        return newMatrix;
    }

    private static void printMatrix(int[][] maxMatrix) {
        for (int i = 0; i < maxMatrix.length; i++) {
            for (int j = 0; j < maxMatrix[i].length; j++) {
                System.out.print(maxMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
