package javaAdvanced.p14GenericsExercises.p06GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();
        while (n-- > 0) {
            box.add(Double.parseDouble(scanner.nextLine()));
        }

        double value = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreater(value));
    }
}
