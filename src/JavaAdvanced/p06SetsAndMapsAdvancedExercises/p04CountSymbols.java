package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner    = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : input) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
