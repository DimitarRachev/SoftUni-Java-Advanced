package javaAdvanced.p09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class p06FindEvensorOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bound = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String condition = scanner.nextLine();

//        int[] numbers = new int[bound[1] - bound[0] + 1];
//        int index = 0;
//        for (int i = bound[0]; i <= bound[1]; i++) {
//            numbers[index++] = i;
//
//        }
//        Arrays.stream(numbers).filter(getFilter(condition)).forEach(e -> System.out.print(e + " "));

            //those two rows work like upper rows^^^^
        IntConsumer printer = e -> System.out.println(e + " ");
        IntStream.rangeClosed(bound[0], bound[1]).filter(getFilter(condition)).forEach(printer);
    }

    private static IntPredicate getFilter(String condition) {
        if (condition.equals("odd")) {
            return e -> e % 2 != 0;
        }
        return e -> e % 2 == 0;
    }
}
