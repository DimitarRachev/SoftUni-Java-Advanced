package javaAdvanced.p10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class p04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input;
        while (!"end".equals(input = scanner.nextLine())) {
            switch (input) {
                case "add":
                    numbers = addToArray.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyToArray.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractToArray.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }

    public static Function<int[], int[]> addToArray = e -> Arrays.stream(e).map(n -> n += 1).toArray();
    public static Function<int[], int[]> subtractToArray = e -> Arrays.stream(e).map(n -> n -= 1).toArray();
    public static Function<int[], int[]> multiplyToArray = e -> Arrays.stream(e).map(n -> n *= 2).toArray();
    public static Consumer<int[]> printer = e -> Arrays.stream(e).forEach(s -> System.out.print(s + " "));
}
