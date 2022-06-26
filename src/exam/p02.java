package exam;

import java.util.Scanner;

public class p02 {
    static char[][] matrix;
    static int row;
    static int col;
    static int cheeseEaten = 0;
    static boolean isGameOver = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
int [][] x = new int[3][3];
        int size = Integer.parseInt(scanner.nextLine());
       String[] commands = scanner.nextLine().split(",");

        matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            //todo check for space in the output DONE
            String line = scanner.nextLine().replace( " ", "");
            matrix[i] = line.toCharArray();
            //todo check for searched sign
            if (line.contains("D")) {
                row = i;
                col = line.indexOf("D");
            }
        }
        for (String command : commands) {
               switch (command) {
                case "up":
                    moveMice(-1, 0);
                    break;
                case "down":
                    moveMice(1, 0);
                    break;
                case "left":
                    moveMice(0, -1);
                    break;
                case "right":
                    moveMice(0, 1);
                    break;
            }
            if (isGameOver) {
                break;
            }
        }

        if (!isGameOver) {
            System.out.println("Your last theft has finished successfully with " + cheeseEaten + "$ in your pocket.");
        }

//        if (cheeseEaten >= 5) {
//            System.out.println("Great job, the mouse is fed " + cheeseEaten + " cheeses!");
//        } else {
//            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - cheeseEaten) + " cheeses more.");
//        }
        printMatrix();
    }

    static void moveMice(int rowMutator, int colMutator) {
        int r = row + rowMutator;
        int c = col + colMutator;
        if (!indexIsValid(r, c)) {
            System.out.println("You cannot leave the town, there is police outside!");
//            matrix[row][col] = '-';
//            isGameOver = true;
            return;
        }
//        boolean haveBonus = false;
        if (matrix[r][c] == '$') {
            cheeseEaten += r * c;
            System.out.println("You successfully stole " + r * c + "$.");
        } else if (matrix[r][c] == 'P') {
            System.out.println("You got caught with " + cheeseEaten + "$, and you are going to jail.");
            matrix[r][c] = '#';
            matrix[row][col] = '+';
            isGameOver = true;
            return;
//            haveBonus = true;
        }

        //todo check the characters
        matrix[row][col] = '+';
        matrix[r][c] = 'D';
        row = r;
        col = c;
//        if (haveBonus) {
//            moveMice(rowMutator, colMutator);
//        }
    }

    private static boolean indexIsValid(int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void printMatrix() {
        //todo check if indices are needed
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
