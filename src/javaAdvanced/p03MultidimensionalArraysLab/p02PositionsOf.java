package javaAdvanced.p03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class p02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][]matrix = new int[input[0]][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int num = Integer.parseInt(scanner.nextLine());
        boolean isNumFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == num) {
                    System.out.println(row + " " + col);
                    isNumFound = true;
                }
            }
        }
        if (!isNumFound) {
            System.out.println("not found");
        }
    }
}
