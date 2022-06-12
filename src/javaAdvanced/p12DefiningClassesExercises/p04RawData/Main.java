package javaAdvanced.p12DefiningClassesExercises.p04RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tyrePresure1 = Double.parseDouble(input[5]);
            int tyreAge1 = Integer.parseInt(input[6]);
            double tyrePresure2 = Double.parseDouble(input[7]);
            int tyreAge2 = Integer.parseInt(input[8]);
            double tyrePresure3 = Double.parseDouble(input[9]);
            int tyreAge3 = Integer.parseInt(input[10]);
            double tyrePresure4 = Double.parseDouble(input[11]);
            int tyreAge4 = Integer.parseInt(input[12]);
            Tyre tyre1 = new Tyre(tyrePresure1, tyreAge1);
            Tyre tyre2 = new Tyre(tyrePresure2, tyreAge2);
            Tyre tyre3 = new Tyre(tyrePresure3, tyreAge3);
            Tyre tyre4 = new Tyre(tyrePresure4, tyreAge4);
            List<Tyre> tyres = new ArrayList<>();
            Tyres set = new Tyres(tyres);
            tyres.add(tyre1);
            tyres.add(tyre2);
            tyres.add(tyre3);
            tyres.add(tyre4);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, set);
            cars.add(car);
        }

        String condition = scanner.nextLine();
        if (condition.equals("fragile")) {
            cars.stream().filter(s -> s.getCargo().getType().equals("fragile")).filter(e -> e.getTyres().haveLowTyre()).forEach(c -> System.out.println(c.getModel()));
        } else {
            cars.stream().filter(s -> s.getCargo().getType().equals("flamable")).filter(e -> e.getEngine().getPower() > 250).forEach(c -> System.out.println(c.getModel()));
        }
    }
}
