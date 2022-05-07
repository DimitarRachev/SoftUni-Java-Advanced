package JavaAdvanced.p08StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class p7MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new FileReader("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        PrintStream printer = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputOne.txt");

        String line;
        while ((line = reader.readLine()) != null) {
            printer.println(line);
        }

        reader = new BufferedReader(new FileReader("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
        while ((line = reader.readLine()) != null) {
            printer.println(line);
        }
    }
}
