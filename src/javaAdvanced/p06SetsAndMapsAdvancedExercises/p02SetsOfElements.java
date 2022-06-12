package javaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer>set1 = new LinkedHashSet<>();
        Set<Integer>set2 = new LinkedHashSet<>();
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < size[0]; i++) {
            set1.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < size[1]; i++) {
            set2.add(Integer.parseInt(scanner.nextLine()));
        }

//        for (Integer s1 : set1) {
//            if (!set2.add(s1)) {
//                System.out.print(s1 + " ");
//            }
//        }
        set1.retainAll(set2);
        set1.forEach(e -> System.out.print(e + " "));

    }
}
