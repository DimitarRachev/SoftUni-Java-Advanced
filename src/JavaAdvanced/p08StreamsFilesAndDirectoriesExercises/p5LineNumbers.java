package JavaAdvanced.p08StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class p5LineNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        PrintStream printer = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt");

        String line;
        int counter = 1;
        while ((line = reader.readLine()) != null) {
            printer.printf("%d. %s%n", counter, line);
            counter++;
        }




    }
}
