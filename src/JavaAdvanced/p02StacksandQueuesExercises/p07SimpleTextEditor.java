package JavaAdvanced.p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder current = new StringBuilder();
        ArrayDeque<String> history = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            switch (input[0]) {
                case "1":
                    String str = input[1];
                    history.push(current.toString());
                    current.append(str);
                    break;
                case "2":
                    int num = Integer.parseInt(input[1]);
                    history.push(current.toString());
                    current.delete(current.length() - num, current.length());
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    System.out.println(current.charAt(index - 1));
                    break;
                case "4":
                    current = new StringBuilder(history.pop());
                    break;
            }
        }
    }
}
