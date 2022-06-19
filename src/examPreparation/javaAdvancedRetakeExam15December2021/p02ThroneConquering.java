package examPreparation.javaAdvancedRetakeExam15December2021;

import java.util.Scanner;

public class p02ThroneConquering {
    static int energy;
    static char[][] matrix;
    static int[] parisPosition;
    static boolean stillGoing = true;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        energy = Integer.parseInt(scanner.nextLine());

        int rows = Integer.parseInt(scanner.nextLine());
        matrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        parisPosition = findParis(matrix);

        while (stillGoing) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int enemyRow = Integer.parseInt(input[1]);
            int enemyCol = Integer.parseInt(input[2]);
            matrix[enemyRow][enemyCol] = 'S';

            switch (command) {
                case "up":
                    moveTo(parisPosition[0] - 1, parisPosition[1]);
                    break;
                case "down":
                    moveTo(parisPosition[0] + 1, parisPosition[1]);
                    break;
                case "left":
                    moveTo(parisPosition[0], parisPosition[1] - 1);
                    break;
                case "right":
                    moveTo(parisPosition[0], parisPosition[1] + 1);
                    break;
            }
        }
    }

    public static void moveTo(int r, int c) {
        if (!indexesAreValid(r, c)) {
            energy--;
            if (energy <= 0) {
                matrix[parisPosition[0]][parisPosition[1]] = 'X';
                System.out.println("Paris died at " + parisPosition[0] + ";" + parisPosition[1] + ".");
                printMatrix();
                stillGoing = false;
                return;
            }
            return;
        }
        matrix[parisPosition[0]][parisPosition[1]] = '-';
        parisPosition = new int[]{r, c};
        if (matrix[r][c] == '-') {
            energy--;
            if (energy <= 0) {
                matrix[r][c] = 'X';
                System.out.println("Paris died at " + r + ";" + c + ".");
                printMatrix();
                stillGoing = false;
                return;
            }
        } else if (matrix[r][c] == 'H') {
            energy--;
            matrix[r][c] = '-';
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
            printMatrix();
            stillGoing = false;
            return;
        } else if (matrix[r][c] == 'S') {
            energy -= 3;
            if (energy <= 0) {
                matrix[r][c] = 'X';
                System.out.println("Paris died at " + r + ";" + c + ".");
                printMatrix();
                stillGoing = false;
                return;
            } else {
                matrix[r][c] = '-';
            }
        }
    }

    public static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] findParis(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'P') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static boolean indexesAreValid(int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
