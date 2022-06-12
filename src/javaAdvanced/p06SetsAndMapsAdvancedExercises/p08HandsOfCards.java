package javaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.*;

public class p08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //hardcode power of the card decks for later calculations
        Map<String, Integer> cardPower = new HashMap<>();
        cardPower.put("2", 2);
        cardPower.put("3", 3);
        cardPower.put("4", 4);
        cardPower.put("5", 5);
        cardPower.put("6", 6);
        cardPower.put("7", 7);
        cardPower.put("8", 8);
        cardPower.put("9", 9);
        cardPower.put("10", 10);
        cardPower.put("J", 11);
        cardPower.put("Q", 12);
        cardPower.put("K", 13);
        cardPower.put("A", 14);
        Map<String, Integer> typePower = new HashMap<>();
        typePower.put("S", 4);
        typePower.put("H", 3);
        typePower.put("D", 2);
        typePower.put("C", 1);

        String line;

        Map<String, Set<String>> game = new LinkedHashMap<>();
        while (!"JOKER".equals(line = scanner.nextLine())) {
            String[] input = line.split(": ");
            String name = input[0];
            String[] cards = input[1].split(", ");
            game.putIfAbsent(name, new HashSet<>());
            for (String s : cards) {
                game.get(name).add(s);
            }
        }

        for (Map.Entry<String, Set<String>> entry : game.entrySet()) {
            String name = entry.getKey();
            int sum = 0;
            for (String s : entry.getValue()) {
                String card =s.substring(0, s.length() - 1);
                String type =String.valueOf(s.charAt(s.length() - 1));
                sum += cardPower.get(card) * typePower.get(type);
            }
            System.out.println(name + ": " + sum);
        }

    }
}
