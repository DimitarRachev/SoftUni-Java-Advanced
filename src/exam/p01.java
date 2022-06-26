package exam;

import java.util.*;
import java.util.stream.Collectors;

public class p01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cocoStack = new ArrayDeque<>();
        //todo check which input is first
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(milkQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(cocoStack::push);


        Map<String, Integer> result = new TreeMap<>();
        while (!cocoStack.isEmpty() && !milkQueue.isEmpty()) {

            //todo check for zero and be careful, than
            // continue;
            double sum =  cocoStack.peek()/(milkQueue.peek() + cocoStack.peek()) *100;

            String product = null;

            if (sum == 30) {
                product = "Milk Chocolate";

            } else if (sum == 50) {
                product = "Dark Chocolate";

            } else if (sum == 100) {
                product = "Baking Chocolate";
            }


            if (product != null) {
                result.putIfAbsent(product, 0);
                result.put(product, result.get(product) + 1);
                cocoStack.pop();
                milkQueue.poll();
            } else {
                //todo check value to increment and queue/stack
                milkQueue.offer(milkQueue.poll() + 10);
                cocoStack.pop();
            }
        }

        //todo check print msgs
        if (result.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        result.entrySet().forEach(e -> System.out.println(" # " + e.getKey() + " --> " + e.getValue()));

        //todo check what you have to print and the delimiter
//        String q = milkQueue.size() == 0 ? "none" : milkQueue.stream().map(String::valueOf).collect(Collectors.joining(" "));
//        String s = cocoStack.size() == 0 ? "none" : cocoStack.stream().map(String::valueOf).collect(Collectors.joining(" "));
//
//        todo print remaining ingredients according to the task
//
//        result.entrySet().forEach(e -> {
//            todo check print delimiter
//            System.out.println(e.getKey() + " -> " + e.getValue());
//        });
    }
}
