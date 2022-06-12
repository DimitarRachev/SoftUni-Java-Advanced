package javaAdvanced.p07StreamsFilesAndDirectoriesLab;

import java.io.*;

public class p3CopyBytes {
    public static void main(String[] args) throws IOException {


        FileInputStream fileStream = new FileInputStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\input.txt");


        FileOutputStream outStream = new FileOutputStream("E:\\Google Download\\10.Phonebook-Skeleton (1)\\SoftUni Java Advanced\\src\\JavaAdvanced\\p07StreamsFilesAndDirectoriesLab\\New folder\\inputCopiedBytes.txt");
        Writer writer = new OutputStreamWriter(outStream);

        int value;

        while (-1 != (value = fileStream.read())) {
            if (value != 32 && value != 10) {
//                String digits = String.valueOf(value);
//                for (int i = 0; i < digits.length(); i++) {
//                    writer.write(digits.charAt(i));
//                }
                writer.write(String.valueOf(value));
            } else {
                writer.write((char) value);
            }
        }
        writer.close();

    }
}
