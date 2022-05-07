package JavaAdvanced.p12DefiningClassesExercises.p07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personsMap = new LinkedHashMap<>();
        String line;
        while (!"End".equals(line= scanner.nextLine())) {
            String[] input = line.split("\\s+");
            String personName = input[0];
            String dataType = input[1];
            personsMap.putIfAbsent(personName, new Person(personName));
            Person person = personsMap.get(personName);
            switch (dataType){
                case "company":
                    String companyName = input[2];
                    String department = input[3];
                    double salary = Double.parseDouble(input[4]);
                    person.setCompany(new Company(companyName, department, salary));
                    break;
                case "pokemon":
                    String pokemonName = input[2];
                    String pokemonType = input[3];
                        person.getPokemons().add(new Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String parentName = input[2];
                    String parentBDay = input[3];
                    person.getParents().add(new Parent(parentName, parentBDay));
                    break;
                case "children":
                    String childName = input[2];
                    String childBday = input[3];
                    person.getChildren().add(new Child(childName, childBday));
                    break;
                case "car":
                    String model = input[2];
                    int speed = Integer.parseInt(input[3]);
                    person.setCar(new Car(model, speed));
                    break;
            }
        }

        String name = scanner.nextLine();
        personsMap.get(name).printPerson();
    }
}
