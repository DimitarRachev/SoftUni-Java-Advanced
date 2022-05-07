package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();
        String line;

        while (!"stop".equals(line = scanner.nextLine())) {
            int count = Integer.parseInt(scanner.nextLine());
            map.putIfAbsent(line, 0);
            map.put(line, map.get(line) + count);
        }

        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
