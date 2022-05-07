package JavaAdvanced.p10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
//        Function<List<Integer>, Integer> getMinNumber = l -> {
//            int minIndex = -1, min = Integer.MAX_VALUE;
//            for (int i = 0; i < l.size(); i++) {
//                if (l.get(i) <= min) {
//                    min = l.get(i);
//                    minIndex = i;
//                }
//            }
//        return minIndex;
//        };

        //same as the upper rows ^^^^
        Function<List<Integer>, Integer> getMinNumber = l -> l.lastIndexOf(l.stream().min(Integer::compare).get());


        System.out.println(getMinNumber.apply(nums));
    }
}
