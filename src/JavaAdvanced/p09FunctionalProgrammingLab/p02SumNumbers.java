package JavaAdvanced.p09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class p02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Function<String, Integer> count = s -> Math.toIntExact(Arrays.stream(s.split(", ")).count());
        Function<String, Integer> sum = s -> Arrays.stream(s.split(", ")).mapToInt(Integer::parseInt).sum();
        System.out.println("Count = " + count.apply(input));
        System.out.println("Sum = " + sum.apply(input));

    }
}
