package javaAdvanced.p03MultidimensionalArraysLab;

import java.util.Scanner;

public class p03IntersectionofTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String notInportant = scanner.nextLine();

        char[][] matrix1 = new char[rows][];
        char[][] matrix2 = new char[rows][];

        readMatrix(scanner, matrix1);
        readMatrix(scanner, matrix2);

        char[][] result = new char[rows][Integer.parseInt(notInportant)];

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row][col] == matrix2[row][col]) {
                    result[row][col] = matrix1[row][col];
                } else {
                    result[row][col] = '*';
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(Scanner scanner, char[][] matrix1) {
        for (int i = 0; i < matrix1.length; i++) {
            matrix1[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}
