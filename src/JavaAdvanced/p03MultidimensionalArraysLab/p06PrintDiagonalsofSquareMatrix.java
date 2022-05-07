package JavaAdvanced.p03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class p06PrintDiagonalsofSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int row = 0;
        int col = 0;
        while (row < matrix.length && col < matrix[0].length) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();
        col = 0;
        row = matrix.length -1;

        while (row >=0 && col < matrix[0].length) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }

    }
}
