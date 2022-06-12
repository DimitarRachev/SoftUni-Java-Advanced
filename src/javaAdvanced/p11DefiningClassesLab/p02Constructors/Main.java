package javaAdvanced.p11DefiningClassesLab.p02Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] input = (scanner.nextLine().split("\\s+"));
            if (input.length == 1) {
                Car car = new Car(input[0]);
                cars.add(car);
            } else {
                Car car = new Car(input[0], input[1], Integer.parseInt(input[2]));
                cars.add(car);
            }
        }
        for (Car car : cars) {
            System.out.println(car.getCarInfo());
        }
    }
}
