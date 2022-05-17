package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>(List.of(scanner.nextLine().split("\\s+")));
        int pass = Integer.parseInt(scanner.nextLine());

        for (int i = pass + 1; i >= 0; i++) {
            if (queue.size() == 1) {
                System.out.println("Last is " + queue.poll());
                return;
            }

            if (i % pass == 0) {
                System.out.println("Removed " + queue.poll());
            } else {
                queue.offer(queue.poll());
            }
        }
    }
}
