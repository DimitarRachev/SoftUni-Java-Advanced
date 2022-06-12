package javaAdvanced.p08StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class p4CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        String line;

        AtomicInteger vowels = new AtomicInteger();
        AtomicInteger consonants = new AtomicInteger();
        AtomicInteger punctuation = new AtomicInteger();
        while ((line = reader.readLine()) != null) {
            Arrays.stream(line.split("\\s+")).forEach(s -> {
                for (char c : s.toCharArray()) {
                    if (c == '!' || c == ',' || c == '.' || c == '?') {
                        punctuation.getAndIncrement();
                    } else if (c == 'u' || c == 'o' || c == 'i' || c == 'e' || c == 'a') {
                        vowels.getAndIncrement();
                    } else {
                        consonants.getAndIncrement();
                    }
                }
            });
        }
        reader.close();
        PrintStream printer = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output1.txt");
        printer.println("Vowels: " + vowels);
        printer.println("Consonants: " + consonants);
        printer.println("Punctuation: " + punctuation);
    }
}
