package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.*;

public class p11LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> userDuration = new TreeMap<>();
        Map<String, Set<String>> userIPs = new HashMap<>();
        while (n-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            String IP = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);
            userDuration.putIfAbsent(user, 0);
            userDuration.put(user, userDuration.get(user) + duration);
            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(IP);
        }

        for (Map.Entry<String, Integer> entry : userDuration.entrySet()) {
            System.out.printf("%s: %d %s%n", entry.getKey(), entry.getValue(), userIPs.get(entry.getKey()));
        }

    }
}
