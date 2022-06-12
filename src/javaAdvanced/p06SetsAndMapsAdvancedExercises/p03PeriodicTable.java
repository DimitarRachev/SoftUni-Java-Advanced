package javaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> table = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[]temp = scanner.nextLine().split(" ");
            for (String s : temp) {
                table.add(s);
            }
        }
        table.forEach(e -> System.out.print(e + " "));
    }
}
