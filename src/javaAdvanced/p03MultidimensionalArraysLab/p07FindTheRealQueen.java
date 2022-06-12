package javaAdvanced.p03MultidimensionalArraysLab;

import java.util.Scanner;

public class p07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'q') {
                    if (positionIsValid(i, j, matrix)) {
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
    }

    private static boolean positionIsValid(int i, int j, char[][] matrix) {
        int row = i - 1;
        int col = j - 1;

        while (row >= 0 && col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row--;
            col--;
        }

        row = i -1;
        col = j +1;
        while (row >= 0 && col < matrix[row].length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row--;
            col++;
        }

        row = i +1;
        col = j -1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row++;
            col--;
        }

        row = i + 1;
        col = j + 1;
        while (row < matrix.length && col < matrix[row].length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row++;
            col++;
        }

        row = i -1;
        col = j;
        while (row >=0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row--;
        }

        row = i +1;
        col = j;
        while (row < matrix.length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
            row++;
        }

        row = i;
        col = j - 1;
        while (col >= 0){
            if (matrix[row][col] == 'q') {
                return false;
            }
            col--;
        }

        row = i;
        col = j + 1;
        while (col < matrix[row].length){
            if (matrix[row][col] == 'q') {
                return false;
            }
            col++;
        }

        return true;
    }
}
