package JavaAdvanced.p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] temp = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int N = temp[0];
        int S = temp[1];
        int X = temp[2];
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.offer(nums[i]);
        }

        for (int i = 0; i < S; i++) {
            queue.poll();
        }

        if (queue.contains(X)) {
            System.out.println("true");
        } else {
            System.out.println(queue.stream().mapToInt(e -> e).min().orElse(0));
        }
    }
}
