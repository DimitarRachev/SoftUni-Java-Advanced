package javaAdvanced.p05SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> map = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            map.put(name, grades);
        }

        String pattern ="#.###################################";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        for (Map.Entry<String, double[]> entry : map.entrySet()) {
            double sum = 0;
            for (double v : entry.getValue()) {
                sum += v;
            }
            sum /= entry.getValue().length;

            System.out.printf("%s is graduated with %s%n", entry.getKey(), decimalFormat.format(sum));
        }
    }
}
