package JavaAdvanced.p12DefiningClassesExercises.p08TOFIXFamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> familyList = new ArrayList<>();
        Map<String, String> parentChild = new LinkedHashMap<>();

        String searchFor = scanner.nextLine();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] input = line.split(" - ");
            if (input.length == 1) {
                input = line.split("\\s+");
                String firstName = input[0];
                String lastName = input[1];
                String name = firstName + " " + lastName;
                String BDay = input[2];
                familyList.add(new Person(name, BDay));

            } else {
                String parent = input[0];
                String child = input[1];
                parentChild.put(parent, child);
            }
        }

        processParents(parentChild, familyList);
        System.out.println(getPerson(searchFor, familyList));
    }

    private static void processParents(Map<String, String> parentChild, List<Person> familyList) {
        for (Map.Entry<String, String> entry : parentChild.entrySet()) {
            Person parent = getPerson(entry.getKey(), familyList);
            Person child = getPerson(entry.getValue(), familyList);
            parent.addChild(child);
            child.addParent(parent);
        }
    }

    private static Person getPerson(String key, List<Person> familyList) {
        for (Person person : familyList) {
            if (person.getName().equals(key) || person.getBirthDay().equals(key)) {
                return person;
            }
        }
        return null;
    }
}

