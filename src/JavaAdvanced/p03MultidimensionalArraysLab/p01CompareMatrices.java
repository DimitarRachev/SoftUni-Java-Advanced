package JavaAdvanced.p03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class p01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = size[0];
        int col = size[1];

        int[][] matrix1 = new int[row][];
        readMatrix(scanner, matrix1);

        int[] size2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix2 = new int[size2[0]][];
        readMatrix(scanner,matrix2);

        if (matricesAreEqual(matrix1, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean matricesAreEqual(int[][] matrix1, int[][] matrix2) {
        for (int row = 0; row < matrix1.length; row++) {
            if (matrix1.length != matrix2.length) {
                return false;
            }
            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row].length != matrix2[row].length) {
                    return false;
                }
                if (matrix1[row][col] != matrix2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
