package javaAdvanced.p08StreamsFilesAndDirectoriesExercises;

import java.io.File;

public class p8GetFolderSize {
    public static void main(String[] args) {

        File file = new File("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p08StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        System.out.println(getDirectorySizeIncludingSubfolders(file));

    }

    private static int getDirectorySizeIncludingSubfolders(File file) {
        int sum = 0;
        File[] files = file.listFiles();
        if (files == null) {
            sum += file.length();
        } else {
            for (File file1 : files) {
                sum += getDirectorySizeIncludingSubfolders(file1);
            }
        }
        return sum;
    }
}
