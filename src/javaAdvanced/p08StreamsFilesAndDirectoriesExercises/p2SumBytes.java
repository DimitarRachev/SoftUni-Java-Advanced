package javaAdvanced.p08StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p2SumBytes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        int c = reader.read();
        long sum = 0;
        while (c != -1) {
            if (c != 13 && c != 10) {
                sum += c;
            }
            c = reader.read();
        }

        System.out.println(sum);
    }
}
