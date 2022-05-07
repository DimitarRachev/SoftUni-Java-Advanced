package JavaAdvanced.p12DefiningClassesExercises.p01OpinionPoll;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person>personsList = new ArrayList<>();
        while (n-- >0) {
            String[]input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            personsList.add(person);
        }
        personsList.sort(Comparator.comparing(Person::getName));
        Consumer<Person> printer = s -> System.out.printf("%s - %d%n", s.getName(), s.getAge());
        personsList.stream().filter(p -> p.getAge() > 30).forEach(printer);
    }
}
