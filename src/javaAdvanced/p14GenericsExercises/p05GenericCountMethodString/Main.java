package javaAdvanced.p14GenericsExercises.p05GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String>box = new Box<>();
        while (n-- > 0) {
            box.add(scanner.nextLine());
        }

        String value = scanner.nextLine();
        System.out.println(box.countGreater(value));
    }
}
