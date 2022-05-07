package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import javax.swing.*;
import java.util.*;

public class p10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countryMap = new LinkedHashMap<>();
        String line;
        while (!"report".equals(line = scanner.nextLine())) {
            String[] input = line.split("\\|");
            String city = input[0];
            String country = input[1];
            long population = Long.parseLong(input[2]);
            countryMap.putIfAbsent(country, new LinkedHashMap<>());
            countryMap.get(country).put(city, population);
        }


        Map<String,Long>mapForSorting = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Long>> entry : countryMap.entrySet()) {

            long  sum = entry.getValue().values().stream().mapToLong(e ->e).sum();
            mapForSorting.put(entry.getKey(), sum);
        }
        mapForSorting.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e ->{

            System.out.printf("%s (total population: %s)%n", e.getKey(), e.getValue());
            countryMap.get(e.getKey()).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(s -> System.out.printf("=>%s: %s%n", s.getKey(), s.getValue()));

        });
    }


}
