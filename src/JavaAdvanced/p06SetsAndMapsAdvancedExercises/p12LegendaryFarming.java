package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.*;

public class p12LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("motes", 0);
        materials.put("fragments", 0);
        Map<String, Integer> junk = new TreeMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i+=2) {
                int qualtity = Integer.parseInt(input[i]);
                String item = input[i +1].toLowerCase(Locale.ROOT);

                if (item.equals("shards") || item.equals("motes") || item.equals("fragments")) {
                    materials.put(item, materials.get(item) + qualtity);
                    if (materials.get(item) >= 250) {
                        materials.put(item, materials.get(item) - 250);
                        printWinner(junk, materials, item);
                        return;
                    }
                } else {
                    junk.putIfAbsent(item, 0);
                    junk.put(item, junk.get(item) + qualtity);
                }
            }
        }
    }

    private static void printWinner(Map<String, Integer> junk, Map<String, Integer> materials, String item) {
        String crafted = "";
        if (item.equals("shards")) {
            crafted = "Shadowmourne obtained!";
        } else if (item.equals("motes")) {
            crafted = "Dragonwrath obtained!";
        } else if (item.equals("fragments")) {
            crafted = "Valanyr obtained!";
        }

        System.out.println(crafted);
        materials.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        junk.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
