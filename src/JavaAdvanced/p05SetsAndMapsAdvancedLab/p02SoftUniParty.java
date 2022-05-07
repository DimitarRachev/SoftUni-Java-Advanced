package JavaAdvanced.p05SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> list = new TreeSet<>();
        String line;
        while (!"PARTY".equals(line = scanner.nextLine())) {
            list.add(line);
        }
        String guest;

        while (!"END".equals(guest = scanner.nextLine())) {
            list.remove(guest);
        }

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
