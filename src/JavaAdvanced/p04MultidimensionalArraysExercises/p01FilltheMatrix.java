package JavaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Scanner;

public class p01FilltheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        int[][] matrix = new int[n][n];

        switch (input[1]) {
            case "A":
                fillMatrixA(n, matrix);
                break;
            case "B":
                fillMatrixB(n, matrix);
                break;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixA(int n, int[][] matrix) {
        int fill = 1;
        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[row][col] = fill;
                fill++;
                row++;
            }
            row = 0;
            col++;
        }
    }

    private static void fillMatrixB(int n, int[][] matrix) {
        int fill =1;
        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[row][col] = fill;
                fill++;
                if (i % 2 == 0 && row != n - 1) {
                    row++;
                } else  if( i % 2 != 0 && row != 0){
                    row--;
                }
            }
            col++;
        }
    }
}
