package examPreparation.javaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class p02Armory {
    static int sum = 0;
    static char[][] armory;
    static int[] position = new int[]{-5, -5};
    static int[] mirror1 = new int[]{-5, -5};
    static int[] mirror2 = new int[]{-5, -5};
    static boolean hasToExit = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        armory = new char[n][n];
        for (int i = 0; i < n; i++) {
            armory[i] = scanner.nextLine().toCharArray();
        }


        for (int i = 0; i < armory.length; i++) {
            for (int j = 0; j < armory[i].length; j++) {
                if (armory[i][j] == 'A') {
                    position[0] = i;
                    position[1] = j;
                } else if (armory[i][j] == 'M') {
                    if (mirror1[0] == -5) {
                        mirror1[0] = i;
                        mirror1[1] = j;
                    } else {
                        mirror2[0] = i;
                        mirror2[1] = j;
                    }
                }
            }
        }
        armory[position[0]][position[1]] = '-';
        int sum = 0;
        while (true) {
            if (hasToExit) {
                if (positionIsValid()) {
                    armory[position[0]][position[1]] = 'A';
                }
                printArmory();
                return;
            }
            String command = scanner.nextLine().trim();
            switch (command) {
                case "up":
                    position[0] = position[0] - 1;
                    checkPosition();
                    break;
                case "down":
                    position[0] = position[0] + 1;
                    checkPosition();
                    break;
                case "left":
                    position[1] = position[1] - 1;
                    checkPosition();
                    break;
                case "right":
                    position[1] = position[1] + 1;
                    checkPosition();
                    break;
            }
        }
    }

    private static void printArmory() {
        for (int i = 0; i < armory.length; i++) {
            for (int j = 0; j < armory[i].length; j++) {
                System.out.print(armory[i][j]);
            }
            System.out.println();
        }
    }

    private static void checkPosition() {
        if (!positionIsValid()) {
            System.out.println("I do not need more swords!");
            System.out.println("The king paid " + sum + " gold coins.");
            hasToExit = true;

            return;
        }
        int r = position[0];
        int c = position[1];
        if (armory[r][c] == 'M') {
            if (mirror1[0] == r && mirror1[1] == c) {
                position[0] = mirror2[0];
                position[1] = mirror2[1];
            } else {
                position[0] = mirror1[0];
                position[1] = mirror1[1];
            }
            armory[mirror1[0]][mirror1[1]] = '-';
            armory[mirror2[0]][mirror2[1]] = '-';
        } else if (armory[r][c] == '-') {

        } else {
            sum += Integer.parseInt(String.valueOf(armory[r][c]));
            armory[r][c] = '-';
            if (sum >= 65) {
                System.out.println("Very nice swords, I will come back for more!");
                System.out.println("The king paid " + sum + " gold coins.");
                hasToExit = true;
                return;
            }
        }
    }

    private static boolean positionIsValid() {
        int r = position[0];
        int c = position[1];
        return r >= 0 && r < armory.length && c >= 0 && c < armory[r].length;
    }
}
