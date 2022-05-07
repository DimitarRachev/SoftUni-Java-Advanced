package JavaAdvanced.p07StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

public class p7ListFiles {
    public static void main(String[] args) throws FileNotFoundException {

        File folder = new File("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\Files-and-Streams");

        PrintStream out = new PrintStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\fileSizes.txt");

        File[] files = folder.listFiles();
        Arrays.stream(files).filter(f -> f.isFile()).forEach(f -> out.printf("%s: [%d]%n", f.getName(), f.length()));

    }
}
