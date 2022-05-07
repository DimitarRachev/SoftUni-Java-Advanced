package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> log = new TreeMap<>();

        String line;

        while (!"end".equals(line = scanner.nextLine())) {
            String[] input = line.split("=");
            String IP = input[1].split(" ")[0];
            String user = input[3];
            log.putIfAbsent(user, new LinkedHashMap<>());
            log.get(user).putIfAbsent(IP, 0);
            log.get(user).put(IP, log.get(user).get(IP) + 1);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : log.entrySet()) {
            System.out.println(entry.getKey() + ":");
            int counter = 0;
            for (Map.Entry<String, Integer> iternalEntry : entry.getValue().entrySet()) {
                counter++;
                System.out.print(iternalEntry.getKey() + " => " + iternalEntry.getValue());
                if (counter == entry.getValue().size()) {
                    System.out.println(".");
                } else {
                    System.out.print(", ");
                }
            }
        }
    }
}
