package JavaAdvanced.p04MultidimensionalArraysExercises;

import java.util.Scanner;

public class p08TheHeiganDance2ndTry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double playerDamage = Double.parseDouble(scanner.nextLine());
        int playerRow = 7;
        int playerCol = 7;
        double heiganHealth = 3000000;
        int playerHealth = 18500;
        boolean isCloudActive = false;

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            String spell = "";
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);
            heiganHealth -= playerDamage;
            if (isCloudActive) {
                playerHealth -= 3500;
                isCloudActive = false;
                if (playerHealth <= 0) {
                    spell = "Plague Cloud";
                    playerIsDead(heiganHealth, spell, playerRow, playerCol);
                    return;
                }
            }
            if (heiganHealth <= 0) {
                heidanIsDead(heiganHealth, playerHealth, playerRow, playerCol);
                return;
            }
            spell = input[0];
            if (playerIsInDmgArea(playerRow, playerCol, row, col)) {
                if (canMoveUp(playerRow, playerCol, row, col)) {
                    playerRow--;
                } else if (canMoveRight(playerRow, playerCol, row, col)) {
                    playerCol++;
                } else if (canMoveDown(playerRow, playerCol, row, col)) {
                    playerRow++;
                } else if (canMoveLeft(playerRow, playerCol, row, col)) {
                    playerCol--;
                } else {
                    switch (spell) {
                        case "Cloud":
                            playerHealth -= 3500;
                            isCloudActive = true;
                            break;
                        case "Eruption":
                            playerHealth -= 6000;
                            break;
                    }
                    if (playerHealth <= 0) {
                        if (spell.equals("Cloud")) {
                            spell = "Plague Cloud";
                        }
                        playerIsDead(heiganHealth,spell,playerRow,playerCol);
                        return;
                    }
                }
            }
        }
    }

    private static void playerIsDead(double heiganHealth, String spell, int playerRow, int playerCol) {
        String heigan = "";
        if (heiganHealth <= 0) {
            heigan = "Heigan: Defeated!";
        } else {
            heigan = String.format("Heigan: %.2f", heiganHealth);
        }
        System.out.println(heigan);
        System.out.println("Player: Killed by " + spell);
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static void heidanIsDead(double heiganHealth, int playerHealth, int playerRow, int playerCol) {
        System.out.println("Heigan: Defeated!");
        System.out.println("Player: " + playerHealth);
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean canMoveLeft(int playerRow, int playerCol, int row, int col) {
        return isValid(playerCol -1) && playerCol < col;
    }

    private static boolean canMoveDown(int playerRow, int playerCol, int row, int col) {
        return isValid(playerRow + 1) && playerRow > row;
    }

    private static boolean canMoveRight(int playerRow, int playerCol, int row, int col) {
        return isValid(playerCol + 1) && playerCol > col;
    }

    private static boolean canMoveUp(int playerRow, int playerCol, int row, int col) {
        return (isValid(playerRow - 1) && playerRow < row);
    }

    private static boolean isValid(int i) {
        return i >= 0 && i < 15;
    }


    private static boolean playerIsInDmgArea ( int playerRow, int playerCol, int row, int col){
        return playerRow <= row + 1 && playerRow >= row - 1 && playerCol <= col + 1 && playerCol >= col - 1;
    }
}
