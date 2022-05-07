package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kids = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        ArrayDeque<String> resultQueue = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int passCouner = 0;
        int cycleCounter = 0;
        while (kids.size() > 1) {

            for (int i = 0; i < kids.size(); i++) {
                passCouner++;
                if (kids.size() == 1) {
                    break;
                }
                if (passCouner % n == 0) {
                    cycleCounter++;
                    if (IsCompositeNumber(cycleCounter)) {

                        resultQueue.offer("Removed " + kids.get(i));
                        kids.remove(i);
                        i--;
                    } else  {
                        resultQueue.offer("Prime " + kids.get(i));
                        i--;
                    }
                }
            }
        }

        while (!resultQueue.isEmpty()) {
            System.out.println(resultQueue.poll());
        }
        System.out.println("Last is " + kids.get(0));

    }
    private  static boolean IsCompositeNumber(int n) {
        //Composite number == !prime Number
        return n == 1 || ((n != 2 && n != 5 && n != 3) && (n % 2 == 0 || n % 5 == 0 || n % 3 == 0));
    }
}
