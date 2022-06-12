package javaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n  =Integer.parseInt(scanner.nextLine());
        int[][]matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int sum1 = 0;
        int row = 0;
        int col = 0;
        while (row < matrix.length && col < matrix[0].length) {
            sum1 += matrix[row][col];
            row++;
            col++;
        }

        int sum2 = 0;
        row = 0;
        col = matrix.length -1;
        while (row < matrix.length && col >=0) {
            sum2 += matrix[row][col];
            row++;
            col--;
        }
        System.out.println(Math.abs(sum1 - sum2));
    }
}
