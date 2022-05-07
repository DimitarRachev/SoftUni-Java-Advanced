package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String line;
        while (!"search".equals(line = scanner.nextLine())) {
            String[] input = line.split("-");
            if (input.length == 2) {
                phonebook.put(input[0], input[1]);
            }
        }

        while (!"stop".equals(line = scanner.nextLine())) {
            if (phonebook.get(line) == null) {
                System.out.printf("Contact %s does not exist.%n", line);
            }  else {
                System.out.printf("%s -> %s%n", line, phonebook.get(line));
            }
        }
    }
}
