package JavaAdvanced.p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] temp = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = temp[0];
        int S = temp[1];
        int X = temp[2];
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            stack.push(nums[i]);
        }

        for (int i = 0; i < S; i++) {
            stack.pop();
        }
        if (stack.contains(X)) {
            System.out.println("true");
        } else {
            System.out.println(stack.stream().mapToInt(e -> e).min().orElse(0));
        }


    }
}
