package javaAdvanced.p10FunctionalProgrammingExercises;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p10PredicateParty {

    static List<String> guestList = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        guestList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String line;
        while (!"Party!".equals(line = scanner.nextLine())) {
            String[] input = line.split("\\s+");
            String command = input[0];
            switch (command) {
                case "Double":
                    addOneMore(getPredicate(input));
                    break;
                case "Remove":
                    removeName(getPredicate(input));
                    break;
            }
        }

        Consumer<List<String>> printer = list ->{
            if(list.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else{
                Collections.sort(guestList);
                System.out.println(guestList.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
            }
            };

            printer.accept(guestList);

//            if (guestList.isEmpty()) {
//                System.out.println("Nobody is going to the party!");
//            } else {
//                Collections.sort(guestList);
//                System.out.println(guestList.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
//            }
    }

    private static void removeName(Predicate<String> predicate) {
            guestList.removeIf(predicate);
    }

    private static void addOneMore(Predicate<String> predicate) {
            List<String> namesToAdd = new ArrayList<>();
            guestList.stream().filter(predicate).forEach(namesToAdd::add);
            guestList.addAll(namesToAdd);
    }

    private static Predicate<String> getPredicate(String[] input) {
        Predicate<String> predicate = null;
        if (input[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(input[2]);
        } else if (input[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(input[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(input[2]);
        }
        return predicate;
    }
}
