package JavaAdvanced.p06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class p07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();
        String line;

        while (!"stop".equals(line = scanner.nextLine())) {
            String mail = scanner.nextLine();
            if (isValid(mail)) {
                emails.put(line, mail);
            }
        }

        emails.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }

    private static boolean isValid(String mail) {
        String postfix = mail.split("@")[1];
        String target = postfix.split("\\.")[1];
//        return !target.toLowerCase(Locale.ROOT).equals("com") && !target.toLowerCase(Locale.ROOT).equals("uk") && !target.toLowerCase(Locale.ROOT).equals("us");
        return !mail.endsWith("us") && !mail.endsWith("com") && !mail.endsWith("uk");
    }
}
