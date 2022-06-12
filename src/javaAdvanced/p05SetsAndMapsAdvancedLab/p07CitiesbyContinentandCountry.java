package javaAdvanced.p05SetsAndMapsAdvancedLab;

import java.util.*;

public class p07CitiesbyContinentandCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>>map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map .get(continent).get(country).add(city);
        }

        for (Map.Entry<String, Map<String, List<String>>> cont : map.entrySet()) {
            System.out.println(cont.getKey() + ":");
            for (Map.Entry<String, List<String>> entry : cont.getValue().entrySet()) {
                System.out.printf("  %s -> %s%n", entry.getKey(), String.join(", ", entry.getValue()));
            }
        }
    }
}
