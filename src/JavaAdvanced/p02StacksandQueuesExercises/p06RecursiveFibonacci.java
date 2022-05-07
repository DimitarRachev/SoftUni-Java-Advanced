package JavaAdvanced.p02StacksandQueuesExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, Double> memory = new HashMap<>();

        System.out.printf("%.0f", getFibonacci(n, memory));
    }

    private static double getFibonacci(int n, Map<Integer, Double> memory) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (memory.containsKey(n)) {
            return memory.get(n);
        }
        double y = getFibonacci(n - 2, memory);
        memory.putIfAbsent(n-2, y);
        double x = getFibonacci(n - 1, memory);
        memory.putIfAbsent(n-1, x);
        double result = getFibonacci(n - 1, memory) + getFibonacci(n - 2, memory);
        memory.put(n, result);
        return result;

    }
}
