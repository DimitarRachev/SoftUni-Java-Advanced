package javaAdvanced.p05SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())){
            String command = input.split(", ")[0];
            String plate = input.split(", ")[1];

            if (command.equals("IN")) {
                parking.add(plate);
            } else if (command.equals("OUT")) {
                parking.remove(plate);
            }
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parking.stream().forEach(System.out::println);
        }
    }
}
