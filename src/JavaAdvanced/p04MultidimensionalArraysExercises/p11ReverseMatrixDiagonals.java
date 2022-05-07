package JavaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = size[0];
        int c = size[1];
        //create and fill matrix
        int[][] matrix = new int[r][];
        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        for (int i = 0; i < r + c - 1; i++) {
            printDiagonal(row, col, matrix);
            col--;
            System.out.println();
        }
    }

    private static void printDiagonal(int row, int col, int[][] matrix) {
        while(row >=0  && col < matrix[0].length) {
            if (isValid(row, matrix.length) && isValid(col, matrix[0].length)) {
                System.out.print(matrix[row][col] + " ");
            }
            row--;
            col++;
        }
    }

    private static boolean isValid(int i, int length) {
        return i >= 0 && i < length;
    }
}
