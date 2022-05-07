package JavaAdvanced.p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p08InfixtoPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<Character> operatorsStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        List<String> equation = new ArrayList<>();
        equation = populateEquation(equation, input);

        for (String s : equation) {
            if ((s.charAt(0) >= 48 && s.charAt(0) <= 57) || (s.charAt(0) >= 65 && s.charAt(0) <= 90) || (s.charAt(0) >= 97 && s.charAt(0) <= 122)) {
                outputQueue.offer(s);
            } else {
                handelnOperators(s, outputQueue, operatorsStack);
            }
        }

//        for (int i = 0; i < input.length(); i++) {
//            char current = input.charAt(i);
//            if ((current >= 48 && current <=57) || (current >= 65 && current <= 90) || (current >= 97 && current <= 122) ) {
//                outputQueue.offer(current);
//            } else {
//                handelnOperators(current, outputQueue, operatorsStack);
//            }
//        }
        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(String.valueOf(operatorsStack.pop()));
        }

        for (String character : outputQueue) {
            System.out.print(character + " ");
        }
    }

    private static List<String> populateEquation(List<String> equation, String input) {
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == ')' || current == '*' || current == '/' || current == '+' || current == '-') {
                equation.add(String.valueOf(current));
            } else if ((current >= 48 && current <= 57) || (current >= 65 && current <= 90) || (current >= 97 && current <= 122)) {
                StringBuilder temp = new StringBuilder();
                temp.append(current);
                int index = i + 1;
                while ((index < input.length()) && ((input.charAt(index) >= 48 && input.charAt(index) <= 57) || (input.charAt(index) >= 65 && input.charAt(index) <= 90) || (input.charAt(index) >= 97 && input.charAt(index) <= 122))) {
                    temp.append(input.charAt(index));
                    index++;
                    i++;
                }
                equation.add(temp.toString());
            }
        }
        return equation;
    }

    private static void handelnOperators(String current, ArrayDeque<String> outputQueue, ArrayDeque<Character> operatorsStack) {
        if (operatorsStack.isEmpty()) {
            operatorsStack.push(current.charAt(0));
            return;
        }
        if (current.charAt(0) == '+' || current.charAt(0) == '-') {
            char previous = operatorsStack.peek();
            if (previous == '*' || previous == '/' || previous == '+' || previous == '-') {
                previous = operatorsStack.pop();
                outputQueue.offer(String.valueOf(previous));
                operatorsStack.push(current.charAt(0));
            } else {
                operatorsStack.push(current.charAt(0));
            }

        } else if (current.charAt(0) == '*' || current.charAt(0) == '/') {
            char previous = operatorsStack.peek();
            if (previous == '*' || previous == '/') {
                previous = operatorsStack.pop();
                outputQueue.offer(String.valueOf(previous));
                operatorsStack.push(current.charAt(0));
            } else {
                operatorsStack.push(current.charAt(0));
            }

        } else if (current.charAt(0) == '(') {
            operatorsStack.push(current.charAt(0));
        } else if (current.charAt(0) == ')') {
            char previous = operatorsStack.pop();
            while (previous != '(') {
                outputQueue.offer(String.valueOf(previous));
                previous = operatorsStack.pop();
            }
        }
    }
}
