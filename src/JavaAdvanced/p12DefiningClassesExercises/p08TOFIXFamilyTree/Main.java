package JavaAdvanced.p12DefiningClassesExercises.p08TOFIXFamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String searchFor = scanner.nextLine();
        List<Person> familyList = new ArrayList<>();
        Map<String, Person> namesMap = new HashMap<>();
        Map<String, Person> BDaysMap = new HashMap<>();
        //set the first person
        {
            String[] temp = searchFor.split(" ");
            if (temp.length == 1) {
                String BDay = searchFor;
                Person person = new Person();
                person.setBirthDay(BDay);
                familyList.add(person);
                BDaysMap.put(BDay, person);

            } else {
                String name = searchFor;
                Person person = new Person();
                person.setName(name);
                familyList.add(person);
                namesMap.put(name, person);
            }
        }

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] input = line.split(" - ");
            if (input.length == 1) {
                input = line.split("\\s+");
                String firstName = input[0];
                String lastName = input[1];
                String name = firstName + " " + lastName;
                String BDay = input[2];
                if (BDaysMap.get(BDay).equals(namesMap.get(name))) {
                    mergePersons(BDaysMap.get(BDay), namesMap.get(name), familyList);
                }

            } else {
                String[] left = input[0].split(" ");
                Person parent = null;
                Person child = null;
                if (left.length == 1) {
                    String BDay = left[0];
                    parent = new Person();
                    parent.setBirthDay(BDay);
                    familyList.add(parent);
                    BDaysMap.put(BDay, parent);
                } else {
                    String name = input[0];
                    parent = new Person();
                    parent.setName(name);
                    familyList.add(parent);
                    namesMap.put(name, parent);
                }
                String[] right = input[1].split(" ");
                if (right.length == 1) {
                    String BDay = right[0];
                    child = new Person();
                    child.setBirthDay(BDay);
                    familyList.add(child);
                    BDaysMap.put(BDay, child);
                } else {
                    String name = input[1];
                    child = new Person();
                    child.setName(name);
                    familyList.add(child);
                    namesMap.put(name, child);
                }
                parent.getChildrens().add(child);
                child.getParents().add(parent);
            }

        }

        System.out.println();
    }

    private static void mergePersons(Person person, Person person1, List<Person> familyList) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < familyList.size(); i++) {
            if (familyList.get(i) == person || familyList.get(i) == person1) {
                indexes.add(i);
            }
        }
        Person firstEntry = familyList.get(indexes.get(0));
        Person secondEntry = familyList.get(indexes.get(1));
        if (firstEntry.getName() == null) {
            firstEntry.setName(secondEntry.getName());
        }
        if (firstEntry.getBirthDay() == null) {
            firstEntry.setBirthDay(secondEntry.getBirthDay());
        }
        for (Person parent : secondEntry.getParents()) {
            firstEntry.getParents().add(parent);
        }
        for (Person children : secondEntry.getChildrens()) {
            firstEntry.getChildrens().add(children);
        }
        familyList.remove((int)indexes.get(1));

        firstEntry.purgeLists();
    }


    }

