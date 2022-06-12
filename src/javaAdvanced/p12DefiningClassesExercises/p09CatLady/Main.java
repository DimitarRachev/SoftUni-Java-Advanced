package javaAdvanced.p12DefiningClassesExercises.p09CatLady;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        List<Cat> catsList = new ArrayList<>();
        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] input = line.split("\\s+");
            String type = input[0];
            String name = input[1];
            double value1 = Double.parseDouble(input[2]);
            switch (type) {
                case "Siamese":
                    catsList.add(new Siamese(name, value1));
                    break;
                case "Cymric":
                    catsList.add(new Cymric(name, value1));
                    break;
                case "StreetExtraordinaire":
                    catsList.add(new StreetExtraordinaire(name, value1));
                    break;
            }
        }

        String name = scanner.nextLine();
        Cat cat = null;
        for (Cat cat1 : catsList) {
            if (cat1.getName().equals(name)) {
                cat = cat1;
                break;
            }
        }

        System.out.println(cat);

    }
}
