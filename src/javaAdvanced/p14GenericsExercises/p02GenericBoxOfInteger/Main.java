package javaAdvanced.p14GenericsExercises.p02GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- >0){
            Box<Integer> stringBox = new Box<>(Integer.parseInt(scanner.nextLine()));
            System.out.print(stringBox);
        }

    }
}
