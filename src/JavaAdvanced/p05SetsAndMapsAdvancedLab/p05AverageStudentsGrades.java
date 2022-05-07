package JavaAdvanced.p05SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class p05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
//            double avgScore = entry.getValue().stream().mapToDouble(e -> e).average().orElse(0);
            double avgScore = 0;
            for (Double d : entry.getValue()) {
                avgScore += d;
            }
            avgScore /= entry.getValue().size();

            List<String> tmp = entry.getValue().stream()
                    .map(e -> String.format("%.2f", e))
                    .collect(Collectors.toList());
            String scores = String.join(" ", tmp);
            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), scores, avgScore);
        }
    }
}
