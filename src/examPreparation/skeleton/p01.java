package examPreparation.skeleton;

import java.util.*;
import java.util.stream.Collectors;

public class p01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //todo check which input is first
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(queue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stack::push);


        Map<String, Integer> result = new TreeMap<>();
        while (!stack.isEmpty() && !queue.isEmpty()) {

            //todo check for zero and be careful, than
            // continue;
            int sum = queue.peek() + stack.peek();

            String product;
            switch (sum) {
                case 0:
                    product = "Bread";
                    break;
                case 50:
                    product = "Cake";
                    break;
                case 75:
                    product = "Pastry";
                    break;
                case 100:
                    product = "Fruit Pie";
                    break;
                default:
                    product = null;
                    break;
            }

            if (product != null) {
                result.putIfAbsent(product, 0);
                result.put(product, result.get(product) + 1);
                stack.pop();
                queue.poll();
            } else {
                //todo check value to increment and queue/stack
                stack.push(stack.pop() + 3);
                queue.poll();
            }
        }

        //todo check print msgs
        if (result.size() == 4) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }

        //todo check what you have to print and the delimiter
        String q = queue.size() == 0 ? "none" : queue.stream().map(String::valueOf).collect(Collectors.joining(" "));
        String s = stack.size() == 0 ? "none" : stack.stream().map(String::valueOf).collect(Collectors.joining(" "));

        //todo print remaining ingredients according to the task

        result.entrySet().forEach( e -> {
            //todo check print delimiter
            System.out.println(e.getKey() + " -> " + e.getValue());
        });
    }
}
