package javaAdvanced.p09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class p04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Double, Double> addVat = d -> d * 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).map(addVat).forEach(x -> System.out.printf("%.2f%n",x));
    }
}
