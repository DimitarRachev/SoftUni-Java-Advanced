package JavaAdvanced.p08StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.Arrays;

public class p1SumLines {
    public static void main(String[] args) throws IOException {

        File file = new File("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        String line = br.readLine();
        while (line != null) {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            System.out.println(sum);
            line = br.readLine();
        }
    }
}
