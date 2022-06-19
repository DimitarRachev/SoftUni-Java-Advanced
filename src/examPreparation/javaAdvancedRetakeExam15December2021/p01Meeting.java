package examPreparation.javaAdvancedRetakeExam15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(malesStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(femalesQueue::offer);

        int matchesCounter = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();
            if (male <= 0) {
                malesStack.pop();
                continue;
            }
            if (female <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (female % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }

            if (female != male) {
                male -= 2;
                malesStack.pop();
                femalesQueue.poll();

                malesStack.push(male);
            } else {
                malesStack.pop();
                femalesQueue.poll();
                matchesCounter++;
            }
        }

        System.out.println("Matches: " + matchesCounter);
        System.out.print("Males left: ");
        System.out.println(malesStack.isEmpty() ? "none" : malesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.print("Females left: ");
        System.out.println(femalesQueue.isEmpty() ? "none" : femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
