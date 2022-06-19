package examPreparation.javaAdvancedExam23October2021;

import java.util.*;

public class p01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredientsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshnessStack::push);

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            if (ingredientsQueue.peek() == 0) {
                ingredientsQueue.poll();
                continue;
            }

            int freshness = freshnessStack.pop();
            int ingredient = ingredientsQueue.poll();

            switch (freshness * ingredient) {
                case 150:
                    cocktails.putIfAbsent("Pear Sour", 0);
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    break;
                case 250:
                    cocktails.putIfAbsent("The Harvest", 0);
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    break;
                case 300:
                    cocktails.putIfAbsent("Apple Hinny", 0);
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    break;
                case 400:
                    cocktails.putIfAbsent("High Fashion", 0);
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);

                    break;
                default:
                    ingredientsQueue.offer(ingredient + 5);
                    break;
            }
        }

        System.out.println(cocktails.size() == 4 ? "It's party time! The cocktails are ready!" : "What a pity! You didn't manage to prepare all cocktails.");
        if (ingredientsQueue.size() > 0) {
            System.out.println("Ingredients left: " + ingredientsQueue.stream().mapToInt(e -> e).sum());
        }

        cocktails.entrySet().stream().forEach(e -> System.out.println(" # " + e.getKey() + " --> " + e.getValue()));
    }
}
