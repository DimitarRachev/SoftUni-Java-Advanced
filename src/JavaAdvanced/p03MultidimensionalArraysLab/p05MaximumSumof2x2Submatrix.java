package JavaAdvanced.p03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class p05MaximumSumof2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] maxMatrix = new int[2][2];
        int maxSum = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length -1; j++) {
                int[][] tempMatrix = new int[2][2];
                tempMatrix[0][0] = matrix[i][j];
                tempMatrix[0][1] = matrix[i][j + 1];
                tempMatrix[1][0] = matrix[i + 1][j];
                tempMatrix[1][1] = matrix[i + 1][j + 1];
                int sum = Arrays.stream(tempMatrix)
                        .map(e -> Arrays.stream(e).sum())
                        .mapToInt(e -> e)
                        .sum();
                if (sum > maxSum) {
                    maxSum = sum;
                    maxMatrix = tempMatrix;
                }
            }
        }
        for (int i = 0; i < maxMatrix.length; i++) {
            for (int j = 0; j < maxMatrix[i].length; j++) {
                System.out.print(maxMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
