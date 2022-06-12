package javaAdvanced.p03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class p04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] martix = new int[size[0]][];
        for (int i = 0; i < martix.length; i++) {
            martix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(martix.length);
        System.out.println(martix[0].length);
        int sum = Arrays.stream(martix)
                .map(e -> Arrays.stream(e).sum())
                .mapToInt(e -> e)
                .sum();
        System.out.println(sum);
    }
}
