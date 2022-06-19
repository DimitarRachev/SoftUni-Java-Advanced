package javaAdvanced;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String[] arr = new String[] {"H", "E", "L", "L" , "O"};
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).parallel().forEach(sb::append);
        System.out.println(sb);
    }
}
