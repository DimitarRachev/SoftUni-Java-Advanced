package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kids = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        ArrayDeque<String> resultQueue = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int gameCounter = 0;
        while (kids.size() > 1) {
            for (int i = 0; i < kids.size(); i++) {
                gameCounter++;
                if (kids.size() == 1) {
                    break;
                }
                if (gameCounter % n  == 0) {
                    resultQueue.offer(kids.get(i));
                    kids.remove(i);
                    i--;
                }
            }
        }

        while (!resultQueue.isEmpty()) {
            System.out.println("Removed " + resultQueue.poll());
        }
        System.out.println("Last is " + kids.get(0));
    }
}
