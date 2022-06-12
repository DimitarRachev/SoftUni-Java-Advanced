package javaAdvanced.p07StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;

import java.io.IOException;

public class p1ReadFile {
    public static void main(String[] args) throws IOException {


        FileInputStream filestream = new FileInputStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\input.txt");
        int value;

        while (-1 != (value = filestream.read())) {
            System.out.print(Integer.toBinaryString(value) + " ");
        }

    }
}
