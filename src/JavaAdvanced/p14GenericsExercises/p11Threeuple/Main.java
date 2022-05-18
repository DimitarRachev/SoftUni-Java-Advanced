package JavaAdvanced.p14GenericsExercises.p11Threeuple;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Threeuple> list = new ArrayList<>();

        String[] address = scanner.nextLine().split("\\s+");
        String[] beer = scanner.nextLine().split("\\s+");
        String[] nums = scanner.nextLine().split("\\s+");

        String name = address[0] + " " + address[1];
        list.add(new Threeuple<>(name, address[2], address[3]));

        list.add(new Threeuple<>(beer[0], Integer.parseInt(beer[1]), Boolean.valueOf(beer[2])));

        list.add(new Threeuple<>(nums[0], Double.parseDouble(nums[1]), nums[2]));

        list.forEach(System.out::println);
    }
}
