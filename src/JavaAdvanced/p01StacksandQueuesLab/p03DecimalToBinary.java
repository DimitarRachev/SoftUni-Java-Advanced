package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int num = Integer.parseInt(scanner.nextLine());

        if (num == 0) {
            System.out.println(0);
            return;
        }
        while (num > 0) {
            int push = num % 2;
            num = num / 2;
            stack.push(push);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
