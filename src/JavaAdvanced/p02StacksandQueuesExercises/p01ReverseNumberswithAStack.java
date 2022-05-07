package JavaAdvanced.p02StacksandQueuesExercises;

import javax.security.sasl.SaslClient;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01ReverseNumberswithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < ints.length; i++) {
            stack.push(ints[i]);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
