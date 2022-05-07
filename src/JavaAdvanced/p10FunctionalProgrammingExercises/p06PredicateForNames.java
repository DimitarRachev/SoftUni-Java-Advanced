package JavaAdvanced.p10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class p06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");

        Predicate<String> lenghtFiler = s -> s.length() <= n;
        Arrays.stream(names).filter(lenghtFiler).forEach(System.out::println);
    }
}
