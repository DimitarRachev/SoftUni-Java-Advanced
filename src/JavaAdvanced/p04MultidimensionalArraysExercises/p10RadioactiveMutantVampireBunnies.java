package JavaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = size[0];
        int c = size[1];

        String[][] lair = new String[r][c];
        //fil the lair matrix
        for (int i = 0; i < r; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                lair[i][j] = String.valueOf(input.charAt(j));
            }
        }

        boolean playerEscapes = false;
        boolean playerHitBunny = false;
        int[] coordinates = getPlayerCoordinated(lair);
        int playerRow = coordinates[0];
        int playerCol = coordinates[1];
        String[] actions = scanner.nextLine().split("");
        for (int i = 0; i < actions.length; i++) {
            String action = actions[i];
            switch (action) {
                case "U":
                    // move up
                    if (playerRow - 1 >= 0) {
                        lair[playerRow][playerCol] = ".";
                        playerRow--;
                        if (lair[playerRow][playerCol].equals("B")) {
                            playerHitBunny = true;
                        } else {
                            lair[playerRow][playerCol] = "P";
                        }
                    } else {
                        lair[playerRow][playerCol] = ".";
                        playerEscapes = true;
                    }
                    break;
                case "L":
                    // move left
                    if (playerCol - 1 >= 0) {
                        // move player
                        lair[playerRow][playerCol] = ".";
                        playerCol--;
                        if (lair[playerRow][playerCol].equals("B")) {
                            playerHitBunny = true;

                        } else {
                            lair[playerRow][playerCol] = "P";
                        }
                    } else {
                        lair[playerRow][playerCol] = ".";
                        playerEscapes = true;
                    }
                    break;
                case "R":
                    //move right
                    if (playerCol + 1 < lair[playerRow].length) {
                        // move player
                        lair[playerRow][playerCol] = ".";
                        playerCol++;
                        if (lair[playerRow][playerCol].equals("B")) {
                            playerHitBunny = true;

                        } else {
                            lair[playerRow][playerCol] = "P";
                        }
                    } else {
                        lair[playerRow][playerCol] = ".";
                        playerEscapes = true;
                    }
                    break;
                case "D":
                    // move down
                    if (playerRow + 1 < lair.length) {
                        // move player
                        lair[playerRow][playerCol] = ".";
                        playerRow++;
                        if (lair[playerRow][playerCol].equals("B")) {
                            playerHitBunny = true;

                        } else {
                            lair[playerRow][playerCol] = "P";
                        }
                    } else {
                        lair[playerRow][playerCol] = ".";
                        playerEscapes = true;
                    }
                    break;
            }

            if (!breedBunnies(lair)) {
                printLair(lair);
                printGameOver(playerRow, playerCol, "dead");
                return;
            }
            if (playerHitBunny) {
                printLair(lair);
                printGameOver(playerRow, playerCol, "dead");
                return;
            }
            if (playerEscapes) {
                printLair(lair);
                printGameOver(playerRow, playerCol, "won");
                return;
            }
        }
    }

    private static void printLair(String[][] lair) {
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                System.out.print(lair[i][j]);
            }
            System.out.println();
        }
    }


    private static boolean breedBunnies(String[][] lair) {
        boolean toReturn = true;
        String[][] newLair = new String[lair.length][lair[0].length];
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                newLair[i][j] = lair[i][j];
            }
        }
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                if (lair[i][j].equals("B")) {
                    newLair[i][j] = "B";
                    if (i != 0) {
                        if (lair[i - 1][j].equals("P")) {

                            toReturn = false;
                        }
                        newLair[i - 1][j] = "B";

                    }
                    if (i != lair.length - 1) {
                        if (lair[i + 1][j].equals("P")) {

                            toReturn = false;
                        }
                        newLair[i + 1][j] = "B";

                    }
                    if (j != 0) {
                        if (lair[i][j - 1].equals("P")) {

                            toReturn = false;
                        }
                        newLair[i][j - 1] = "B";

                    }
                    if (j != lair[i].length - 1) {
                        if (lair[i][j + 1].equals("P")) {

                            toReturn = false;
                        }
                        newLair[i][j + 1] = "B";

                    }
                }
            }
        }
        for (int i = 0; i < newLair.length; i++) {
            for (int j = 0; j < newLair[i].length; j++) {
                lair[i][j] = newLair[i][j];
            }
        }
        return toReturn;
    }

    private static int[] getPlayerCoordinated(String[][] lair) {
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[0].length; j++) {
                if (lair[i][j].equals("P")) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static void printGameOver(int playerRow, int playerCol, String status) {
        System.out.printf("%s: %d %d", status, playerRow, playerCol);
    }
}
