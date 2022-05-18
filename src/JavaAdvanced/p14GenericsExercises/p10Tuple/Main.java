package JavaAdvanced.p14GenericsExercises.p10Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tuple> list = new ArrayList<>();

        String[] adress = scanner.nextLine().split("\\s+");
        String[] beer = scanner.nextLine().split("\\s+");
        String[] nums = scanner.nextLine().split("\\s+");

        String name = adress[0] + " " + adress[1];
        String adres = adress[2];
        Tuple<String, String> one = new Tuple<>(name, adres);
        list.add(one);

        Tuple<String, Integer> two = new Tuple<>(beer[0], Integer.parseInt(beer[1]));
        list.add(two);

        Integer n = Integer.parseInt(nums[0]);
        Double d = Double.parseDouble(nums[1]);
        Tuple<Integer, Double> three = new Tuple<>(n, d);
        list.add(three);

        list.forEach(System.out::println);

    }
}
