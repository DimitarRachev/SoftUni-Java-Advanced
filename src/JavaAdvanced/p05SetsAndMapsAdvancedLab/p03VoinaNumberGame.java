package JavaAdvanced.p05SetsAndMapsAdvancedLab;

import java.util.*;

public class p03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(firstPlayerCards::add);
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(secondPlayerCards::add);

        for (int i = 0; i < 50; i++) {
            int firstNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstNumber);

            int secondNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondNumber);

            if (secondNumber > firstNumber) {
                secondPlayerCards.add(firstNumber);
                secondPlayerCards.add(secondNumber);
            } else if (firstNumber > secondNumber) {
                firstPlayerCards.add(firstNumber);
                firstPlayerCards.add(secondNumber);
            }

            if (secondPlayerCards.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
            if (firstPlayerCards.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }
        }
        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerCards.size() < secondPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
