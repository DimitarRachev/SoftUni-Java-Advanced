package javaAdvanced.p08StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class p6WordCount {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String s : words) {
                map.put(s, 0);
            }
        }

        reader = new BufferedReader(new FileReader("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String s : words) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
            }
        }
        reader.close();
        PrintStream printer = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt");
        map.forEach((key, value) -> printer.println(key + " - " + value));
        printer.close();
    }
}
