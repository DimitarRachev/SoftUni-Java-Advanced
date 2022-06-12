package javaAdvanced.p07StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class p4ExtractIntegers {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\input.txt");

        PrintStream print = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\ExtractIntegers.txt");

        Scanner scanner = new Scanner(path);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {

                print.println(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        print.close();
    }
}
