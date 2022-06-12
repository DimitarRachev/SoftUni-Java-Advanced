package javaAdvanced.p14GenericsExercises.p11Threeuple;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] address = scanner.nextLine().split("\\s+");
        String[] beer = scanner.nextLine().split("\\s+");
        String[] nums = scanner.nextLine().split("\\s+");

        String name = address[0] + " " + address[1];
        System.out.println(new Threeuple<>(name, address[2], address[3]));

        System.out.println(new Threeuple<>(beer[0], Integer.parseInt(beer[1]), beer[2].equals("drunk") ? "true" : "false"));

        System.out.println(new Threeuple<>(nums[0], Double.parseDouble(nums[1]), nums[2]));


    }
}
