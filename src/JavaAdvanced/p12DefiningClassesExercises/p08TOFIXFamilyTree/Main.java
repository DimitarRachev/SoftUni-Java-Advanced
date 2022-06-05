package JavaAdvanced.p12DefiningClassesExercises.p08TOFIXFamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> familyListMap = new LinkedHashSet<>();
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
                familyListMap.add(new Person(name, BDay));

            } else {
                String parent = input[0];
                String child = input[1];
                parentChild.put(parent, child);
            }
        }

        processParents(parentChild, familyListMap);
        System.out.println(getPerson(searchFor, familyListMap));
    }

    private static void processParents(Map<String, String> parentChild, Set<Person> familyListMap) {
        for (Map.Entry<String, String> entry : parentChild.entrySet()) {
            Person parent = getPerson(entry.getKey(), familyListMap);
            Person child = getPerson(entry.getValue(), familyListMap);
            parent.addChild(child);
            child.addParent(parent);
        }
    }

    private static Person getPerson(String key, Set<Person> familyListMap) {
        for (Person person : familyListMap) {
            if (person.getName().equals(key) || person.getBirthDay().equals(key)) {
                return person;
            }
        }
        return null;
    }
}

