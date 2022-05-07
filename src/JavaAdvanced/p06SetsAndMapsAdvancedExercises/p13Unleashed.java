package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(?<singer>[A-Za-z ]+) @(?<venue>[A-Za-z ]+) (?<ticketPrice>\\d+) (?<ticketCount>\\d+)");

        String input;
        while (!"End".equals(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);
            String name = "";
            String venue = "";
            int price = 0;
            int ticketCount = 0;

            while (matcher.find()) {
                name = matcher.group("singer");
                venue = matcher.group("venue");
                price = Integer.parseInt(matcher.group("ticketPrice"));
                ticketCount = Integer.parseInt(matcher.group("ticketCount"));

                map.putIfAbsent(venue, new LinkedHashMap<>());
                map.get(venue).putIfAbsent(name, 0);
                map.get(venue).put(name, map.get(venue).get(name) + price * ticketCount);
            }
        }

        map.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });
    }
}
