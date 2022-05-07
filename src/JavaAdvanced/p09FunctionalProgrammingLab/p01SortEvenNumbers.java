package JavaAdvanced.p09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p01SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Predicate<Integer> getEvens = x -> x % 2 == 0;

        List<Integer> stream = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).filter(getEvens).collect(Collectors.toList());

        Consumer<List<Integer>> printer = x -> System.out.println(x.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        printer.accept(stream);
        System.out.println(stream.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));


    }
}
