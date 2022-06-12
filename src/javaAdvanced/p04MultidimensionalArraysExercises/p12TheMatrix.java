package javaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        String filChar = scanner.nextLine();

        int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startRow = coordinates[0];
        int startCol = coordinates[1];
        String startChar = matrix[startRow][startCol];
        matrix[startRow][startCol] = filChar;

        fillMartix(filChar, startChar, startRow, startCol, matrix);
        printMatrix(matrix);
    }

    private static void fillMartix(String filChar, String startChar, int startRow, int startCol, String[][] matrix) {
        if (isValid(startRow - 1, matrix.length) && isValid(startCol, matrix[0].length) && matrix[startRow - 1][startCol].equals(startChar)) {
            matrix[startRow - 1][startCol] = filChar;
            fillMartix(filChar, startChar, startRow - 1, startCol, matrix);
        }
        if (isValid(startRow + 1, matrix.length) && isValid(startCol, matrix[0].length) && matrix[startRow + 1][startCol].equals(startChar)) {
            matrix[startRow + 1][startCol] = filChar;
            fillMartix(filChar, startChar, startRow + 1, startCol, matrix);
        }
        if (isValid(startRow, matrix.length) && isValid(startCol - 1, matrix[0].length) && matrix[startRow][startCol - 1].equals(startChar)) {
            matrix[startRow][startCol - 1] = filChar;
            fillMartix(filChar, startChar, startRow, startCol - 1, matrix);
        }
        if (isValid(startRow, matrix.length) && isValid(startCol + 1, matrix[0].length) && matrix[startRow][startCol + 1].equals(startChar)) {
            matrix[startRow][startCol + 1] = filChar;
            fillMartix(filChar, startChar, startRow, startCol + 1, matrix);
        }
    }

    private static boolean isValid(int i, int length) {
        return i >= 0 && i < length;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
