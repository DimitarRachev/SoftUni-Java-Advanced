package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> result = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) ==  '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                int startIndex = stack.pop();
                result.add(input.substring(startIndex, i + 1));
            }
        }
        result.stream().forEach(System.out::println);

    }
}
