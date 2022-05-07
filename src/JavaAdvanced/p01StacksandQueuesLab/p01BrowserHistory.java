package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        ArrayDeque<String> history = new ArrayDeque<>();
        String current = null;
        while (!"Home".equals(line = scanner.nextLine())) {
            if (line.equals("back")) {
                if (history.size() <= 0) {
                    System.out.println("no previous URLs");
                } else {
                    current = history.pop();
                    System.out.println(current);

                }
            } else {
                if (current != null) {
                    history.push(current);
                }
                current = line;
                System.out.println(current);
            }

        }

    }
}
