package JavaAdvanced.p10FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p11ThePartyReservationFilterModule {

    static List<String> guestList;
    static List<String> removedGuests = new ArrayList<>();
  static   Map<String, Predicate<String>> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        guestList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String line;

        while (!"Print".endsWith(line = scanner.nextLine())) {
            String[] input = line.split(";");
            String command = input[0];
            switch (command) {
                case "Add filter":
//                    addFilter(getFilter(input));
                    addFilterMap(getFilter(input), input[1] + input[2]);
                    break;
                case "Remove filter":
//                    removeFilter(getFilter(input));
                    removeFilterMap(getFilter(input), input[1] + input[2]);
                    break;
            }
        }

        Consumer<String> printer = s -> System.out.print(s + " ");
//        guestList.forEach(printer);
        guestList.stream().filter( guest -> {
           boolean isValid = true;
            for (Predicate<String> predicate : map.values()) {
                if (predicate.test(guest)) {
                    return  false;
                }
            }
            return isValid;
        }).forEach(printer);
    }

    private static void removeFilterMap(Predicate<String> filter, String name) {
        map.remove(name);
    }

    private static void addFilterMap(Predicate<String> filter, String name) {
        map.put(name, filter);
    }

    private static void removeFilter(Predicate<String> filter) {
        List<String> filtered = new ArrayList<>();
        removedGuests.stream().filter(filter).forEach(filtered::add);
        guestList.addAll(filtered);
        removedGuests.removeAll(filtered);
    }

    private static void addFilter(Predicate<String> filter) {
        List<String> filtered = new ArrayList<>();
        guestList.stream().filter(filter).forEach(filtered::add);
        guestList.removeAll(filtered);
        removedGuests.addAll(filtered);
    }

    private static Predicate<String> getFilter(String[] input) {
        Predicate<String> predicate = null;
        switch (input[1]) {
            case "Starts with":
                predicate = n -> n.startsWith(input[2]);
                break;
            case "Ends with":
                predicate = n -> n.endsWith(input[2]);
                break;
            case "Length":
                predicate = n -> n.length() == Integer.parseInt(input[2]);
                break;
            case "Contains":
                predicate = n -> n.contains(input[2]);
                break;
        }
        return predicate;
    }
}
