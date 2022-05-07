package JavaAdvanced.p09FunctionalProgrammingLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class p05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> map = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] input = scanner.nextLine().split(", ");
            map.put(input[0], Integer.parseInt(input[1]));
        }

        String condition = scanner.nextLine();
        int delimiter = Integer.parseInt(scanner.nextLine());
        String[] printFormating = scanner.nextLine().split(" ");

        Predicate<Map.Entry<String, Integer>> filter = getAgeFilter(condition, delimiter);

        Consumer<Map.Entry<String, Integer>> printer = getPrinter(printFormating);
        printResult(filter, printer, map);

    }

    private static Consumer<Map.Entry<String, Integer>> getPrinter(String[] printFormatting) {
        if (printFormatting.length  == 1){

            if (printFormatting[0].equals("name")) {
                return e -> System.out.println(e.getKey());
            } else if (printFormatting[0].equals("age")) {
                return e -> System.out.println(e.getValue());
            }
        }
        return e -> System.out.println(e.getKey() + " - " + e.getValue());
    }

    private static void printResult(Predicate<Map.Entry<String, Integer>> sortOrder, Consumer<Map.Entry<String, Integer>> printer, Map<String, Integer> map) {
        map.entrySet().stream().filter(sortOrder).forEach(printer);
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(String condition, int delimiter) {
        if (condition.equals("older")) {
            return e -> e.getValue() >= delimiter;
        }
        return e -> e.getValue() <= delimiter;
    }


}
