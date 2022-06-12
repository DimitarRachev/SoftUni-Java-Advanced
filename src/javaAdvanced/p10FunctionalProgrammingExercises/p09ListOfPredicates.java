package javaAdvanced.p10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());

        Predicate<Integer> isDivisible = num -> {
            for (Integer divider : numbers) {
                if (num % divider != 0) {
                    return false;
                }
            }            return true;
        };

        IntStream.rangeClosed(1, n).boxed().filter(isDivisible).forEach(s -> System.out.print(s + " "));
    }
}
