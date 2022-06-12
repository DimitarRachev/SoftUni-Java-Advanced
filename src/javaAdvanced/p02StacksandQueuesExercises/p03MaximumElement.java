package javaAdvanced.p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            switch (command) {
                case "1":
                    int X = Integer.parseInt(input[1]);
                    stack.push(X);
                    break;
                case  "2":
                    stack.pop();
                    break;
                case  "3":
                    System.out.println(stack.stream().mapToInt(Integer::intValue).max().orElse(0));
                    break;
            }
        }
    }
}
