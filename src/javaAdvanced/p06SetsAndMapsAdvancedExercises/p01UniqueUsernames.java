package javaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            set.add(scanner.nextLine());
        }

        set.forEach(System.out::println);
    }
}
