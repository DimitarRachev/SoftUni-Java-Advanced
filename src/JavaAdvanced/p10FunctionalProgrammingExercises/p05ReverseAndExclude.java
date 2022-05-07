package JavaAdvanced.p10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int n = scanner.nextInt();
        Predicate<Integer> filterN = e -> e % n != 0;

        Collections.reverse(numbers);
        numbers.stream().filter(filterN).forEach(i -> System.out.print(i + " "));
    }
}
