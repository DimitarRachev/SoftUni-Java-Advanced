package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        for (String s : input) {
            queue.offer(s);
        }

        while (queue.size() > 1) {
            int leftInt = Integer.parseInt(queue.poll());
            String sign = queue.poll();
            int rightInt = Integer.parseInt(queue.poll());

            String tmp = ("+").equals(sign)
                    ? (String.valueOf(leftInt + rightInt))
                    : (String.valueOf(leftInt - rightInt));
            queue.addFirst(tmp);
        }

        System.out.println(queue.poll());


    }
}
