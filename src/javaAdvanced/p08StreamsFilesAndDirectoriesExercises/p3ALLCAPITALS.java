package javaAdvanced.p08StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.Locale;

public class p3ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        PrintStream print = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        String line;
        while ((line = reader.readLine()) != null) {
            print.println(line.toUpperCase(Locale.ROOT));
        }
        print.close();
    }
}
