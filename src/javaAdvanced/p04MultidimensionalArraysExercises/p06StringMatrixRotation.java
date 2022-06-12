package javaAdvanced.p04MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(command);
        int degree = 0;
        while (matcher.find()){
            degree = Integer.parseInt(matcher.group());
        }

        String line;
//get string for the initial matrix
        List<String> input = new ArrayList<>();
        while (!"END".equals(line = scanner.nextLine())) {
            input.add(line);
        }
//calculate cal colon length
        int cols = input.stream()
                .mapToInt(e -> e.length())
                .max().orElse(0);
//populate initial matrix
        char[][] matrix = new char[input.size()][cols];
        for (int i = 0; i < input.size(); i++) {
            while (input.get(i).length() < cols) {
                input.set(i, input.get(i) + " ");
            }
            matrix[i] = input.get(i).toCharArray();
        }
//calculate rotation index
        int rotate = degree / 90;
        while (rotate >= 4) {
            rotate -=4;
        }
//print correctly rotated matrix
        if (rotate == 1) {
            printMatrix(rotate90(matrix));
        } else if (rotate == 2) {
            printMatrix(rotate180(matrix));
        } else if (rotate == 3) {
            printMatrix(rotate270(matrix));
        } else {
            printMatrix(matrix);
        }

    }

    private static char[][] rotate270(char[][] matrix) {
        char[][] newMatrix = new char[matrix[0].length][matrix.length];
        int r = 0;
        int c = matrix[0].length - 1;
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = matrix[r][c];
                r++;
            }
            c--;
            r = 0;
        }
        return newMatrix;
    }

    private static char[][] rotate180(char[][] matrix) {
        char[][] newMatrix = new char[matrix.length][matrix[0].length];
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = matrix[r][c];
                c--;
            }
            r--;
            c = matrix[0].length - 1;
        }
        return newMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] rotate90(char[][] matrix) {
        char[][] newMatrix = new char[matrix[0].length][matrix.length];
        int r = matrix.length - 1;
        int c = 0;
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = matrix[r][c];
                r--;
            }
            c++;
            r = matrix.length - 1;
        }
        return newMatrix;
    }
}
