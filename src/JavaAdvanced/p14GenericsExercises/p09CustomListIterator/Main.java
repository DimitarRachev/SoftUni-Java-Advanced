package JavaAdvanced.p14GenericsExercises.p09CustomListIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        CustomList<String> customList = new CustomList<>();

        while (!"END".equals(line = scanner.nextLine())) {
            String[] input = line.split("\\s+");
            if (input[0].equals("Add")) {
                String element = input[1];
                customList.add(element);
            } else if (input[0].equals("Remove")) {
                int index = Integer.parseInt(input[1]);
                customList.remove(index);
            } else if (input[0].equals("Contains")) {
                String element = input[1];
                System.out.println(customList.contains(element));
            } else if (input[0].equals("Swap")) {
                int index = Integer.parseInt(input[1]);
                int index1 = Integer.parseInt(input[2]);
                customList.swap(index, index1);
            } else if (input[0].equals("Greater")) {
                String element = input[1];
                System.out.println(customList.countGreaterThan(element));
            } else if (input[0].equals("Max")) {
                System.out.println(customList.getMax());
            } else if (input[0].equals("Min")) {
                System.out.println(customList.getMin());
            } else if (input[0].equals("Print")) {
                System.out.print(customList);
            } else if (input[0].equals("Sort")) {
              Sorter.sort(customList);
            }
        }
    }
}
