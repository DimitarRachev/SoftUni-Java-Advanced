package javaAdvanced.p10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class p02KnightsofHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Consumer<String> printer = e -> Arrays.stream(e.split("\\s+")).forEach(s -> System.out.println("Sir " + s));
        printer.accept(input);
    }
}
