package javaAdvanced.p07StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class p2WritetoFile {
    public static void main(String[] args) throws IOException {

        FileInputStream fileStream = new FileInputStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\input.txt");
        FileWriter writer = new FileWriter("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\inputWithoutPunctuation.txt");
        int value;

        while (-1 != (value = fileStream.read())) {
            if (value != '!' && value != '?' && value != ',' && value != '.') {
                writer.write((char) value);
            }
        }
        writer.close();
    }
}
