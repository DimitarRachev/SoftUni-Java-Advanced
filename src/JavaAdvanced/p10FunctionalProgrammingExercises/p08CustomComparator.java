package JavaAdvanced.p10FunctionalProgrammingExercises;

import java.util.Arrays;

import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;


public class p08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

//        Consumer<int[]> printer = arr -> {
//            Arrays.stream(arr).filter(n -> n % 2 == 0).sorted().forEach(e -> System.out.print(e + " "));
//            Arrays.stream(arr).filter(n -> n % 2 != 0).sorted().forEach(e -> System.out.print(e + " "));
//        };
//
//        printer.accept(numbers);

        Comparator<Integer> comparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 %2 != 0) {
                return -1;
            } else if (num1 % 2 != 0 && num2 %2 == 0) {
                return 1;
            }
            return num1.compareTo(num2);
        };

        Arrays.stream(numbers).boxed().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
