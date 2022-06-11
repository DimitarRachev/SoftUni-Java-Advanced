package examPreparation.javaAdvancedRetakeExam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class p1Blacksmith {
    public static void main(String[] args) {
        final int Gladius = 70;
        final int Shamshir = 80;
        final int Katana = 90;
        final int Sabre = 110;
        Map<Integer, String> swords = new HashMap<>();
        swords.put(Shamshir, "Shamshir");
        swords.put(Sabre, "Sabre");
        swords.put(Katana, "Katana");
        swords.put(Gladius, "Gladius");

        Map<String, Integer> result = new TreeMap<>();
        result.put("Shamshir", 0);
        result.put("Sabre", 0);
        result.put("Katana", 0);
        result.put("Gladius", 0);

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> steel = new ArrayDeque<>(); // queue //remove
        ArrayDeque<Integer> carbon = new ArrayDeque<>(); //stack //offerLast
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(steel::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(carbon::push);

        while (!steel.isEmpty()) {
            Integer carbonValue = carbon.pop();
            int sum = carbonValue + steel.poll();
            if (swords.containsKey(sum)) {
                result.put(swords.get(sum), result.get(swords.get(sum)) + 1);
            } else {
                carbonValue += 5;
                carbon.push(carbonValue);
            }
        }

        long size = result.entrySet().stream().map(Map.Entry::getValue).mapToInt(e -> e).sum();
        if (size > 0) {
            System.out.println("You have forged " + size + " swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        System.out.print("Steel left: ");
        if (steel.size() == 0) {
            System.out.println("none");
        } else {
            System.out.println(steel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.print("Carbon left: ");
        System.out.println(carbon.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        if (size > 0) {
            result.entrySet().stream().filter(s -> s.getValue() > 0).forEach(v -> System.out.println(v.getKey() + ": " + v.getValue()));
        }
    }
}
