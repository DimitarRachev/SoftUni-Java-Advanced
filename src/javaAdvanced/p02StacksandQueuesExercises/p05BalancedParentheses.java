package javaAdvanced.p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            if (x == '{' || x == '[' || x == '(') {
                stack.push(x);
            } else if (stack.isEmpty() || !areBalanced(stack.pop(), x)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static boolean areBalanced(Character pop, char x) {
        return (pop == '{' && x == '}') || (pop == '[' && x == ']') || (pop == '(' && x == ')');
    }
}
