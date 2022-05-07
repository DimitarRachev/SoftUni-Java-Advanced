package JavaAdvanced.p14GenericsExercises.p04GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        while (n-- > 0) {
            box.add(Integer.parseInt(scanner.nextLine()));
        }

        int[] index = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        box.swap(index[0], index[1]);
        System.out.print(box);
    }
}
