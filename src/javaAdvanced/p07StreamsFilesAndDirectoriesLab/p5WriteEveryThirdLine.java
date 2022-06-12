package javaAdvanced.p07StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Scanner;

public class p5WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\input.txt");
        Scanner scanner = new Scanner(path);
        PrintStream out = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\every3rdLine.txt");

        int counter = 1;

        while (scanner.hasNext()){
            if (counter % 3 == 0) {
                out.println(scanner.nextLine());
            } else {
                scanner.nextLine();
            }
            counter++;
        }

    }
}
