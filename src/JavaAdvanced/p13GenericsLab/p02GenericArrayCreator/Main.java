package JavaAdvanced.p13GenericsLab.p02GenericArrayCreator;

import java.util.Arrays;

public class Main  {
    public static void main(String[] args) {

        Integer[] integers = ArrayCreator.create(10, 2);
        Arrays.stream(integers).forEach(System.out::println);

        String[] strings = ArrayCreator.create(String.class, 10, "a");
        Arrays.stream(strings).forEach(System.out::println);
    }
}
