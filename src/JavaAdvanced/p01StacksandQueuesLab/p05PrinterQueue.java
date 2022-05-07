package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printQueue = new ArrayDeque<>();
        String input;
        while (!"print".equals(input = scanner.nextLine())) {

            if (input.equals("cancel")) {
                if (printQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printQueue.poll());
                }

            } else {
                printQueue.offer(input);
            }
        }

        while (!printQueue.isEmpty()) {
            System.out.println(printQueue.poll());
        }


    }
}
