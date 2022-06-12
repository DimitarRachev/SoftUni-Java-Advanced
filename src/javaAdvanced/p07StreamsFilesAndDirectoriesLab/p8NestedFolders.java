package javaAdvanced.p07StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class p8NestedFolders {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\Files-and-Streams");

        PrintStream out = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\nestedFiles.txt");

        ArrayDeque<File> stack = new ArrayDeque<>();
        int counter = 0;
        stack.push(file);
        while (!stack.isEmpty()) {
            File current = stack.poll();
            if (current.isDirectory()) {
                out.println(current.getName());
                counter++;
                for (File file1 : current.listFiles()) {
                    stack.offer(file1);
                }
            }
        }
out.printf("%d folders", counter);
    }
}
