package JavaAdvanced.p07StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p6SortLines {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\input.txt");

        Scanner scanner = new Scanner(file);

        List<String> lines = new ArrayList<>();
        while (scanner.hasNext()){
            lines.add(scanner.nextLine());
        }

        Collections.sort(lines);

        PrintStream out = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\sortOutput.txt");
        lines.stream().forEach(out::println);
    }
}
