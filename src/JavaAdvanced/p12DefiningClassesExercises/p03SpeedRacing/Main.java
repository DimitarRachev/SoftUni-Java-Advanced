package JavaAdvanced.p12DefiningClassesExercises.p03SpeedRacing;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> map = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] input = (scanner.nextLine().split("\\s+"));
            Car car = new Car(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]));
            map.put(input[0], car);
        }

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] input = line.split("\\s+");
            String carName = input[1];
            Double km = Double.parseDouble(input[2]);
            if (!map.get(carName).drive(km)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }

//        for (Map.Entry<String, Car> entry : map.entrySet()) {
//            System.out.printf("%s %.2f %.0f%n", entry.getKey(), entry.getValue().getFuelAmount(), entry.getValue().getDistanceTraveled());
//        }
        map.values().forEach(System.out::println);
    }
}
