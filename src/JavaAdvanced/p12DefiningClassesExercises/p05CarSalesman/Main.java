package JavaAdvanced.p12DefiningClassesExercises.p05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            String displacement = "n/a";
            String efficiency = "n/a";
            if (input.length > 2) {
                try {
                    int temp = Integer.parseInt(input[2]);
                    displacement = input[2];
                    if (input.length > 3) {
                        efficiency = input[3];
                    } else {
                        efficiency = "n/a";
                    }
                } catch (Exception e) {
                    efficiency = input[2];
                    displacement = "n/a";
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.put(model, engine);
        }

        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            Engine engine = engines.get(input[1]);
            String weight = "n/a";
            String color = "n/a";
            if (input.length > 2) {
                try {
                    int temp = Integer.parseInt(input[2]);
                    weight = input[2];
                    if (input.length > 3) {
                        color = input[3];
                    }
                } catch (Exception e) {
                    color = input[2];
                }
            }
            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }

        cars.forEach(System.out::print);
    }
}
