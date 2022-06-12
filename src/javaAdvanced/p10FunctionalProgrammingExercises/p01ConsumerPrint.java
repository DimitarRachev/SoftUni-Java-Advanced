package javaAdvanced.p10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class p01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Consumer<String> printer = e -> Arrays.stream(e.split("\\s+")).forEach(System.out::println);
        printer.accept(input);
    }
}
