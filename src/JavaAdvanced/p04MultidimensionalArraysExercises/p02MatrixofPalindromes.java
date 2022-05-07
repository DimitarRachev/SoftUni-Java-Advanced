package JavaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p02MatrixofPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][]matrix = new String[size[0]][size[1]];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int a = 97 + i;
                int b = 97 + j + i;
                String fill = String.valueOf((char) a) + String.valueOf((char) b) + String.valueOf((char) a);
                matrix[i][j] = fill;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
