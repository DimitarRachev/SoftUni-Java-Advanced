package javaAdvanced.p05SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer>map = new LinkedHashMap<>();
        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        for (double v : input) {
            map.putIfAbsent(v, 0);
            map.put(v, map.get(v) + 1);
        }
        map.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
