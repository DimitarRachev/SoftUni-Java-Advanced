package javaAdvanced.p13GenericsLab.p02GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {


   public static<T> T[] create(int length, T item) {
        T[] arr = (T[])Array.newInstance(item.getClass(), length);
        Arrays.fill(arr, item);
        return arr;
    }

public static<T> T[] create(Class<T> claz, int length, T item) {
       T[] arr =(T[])Array.newInstance(claz, length);
       Arrays.fill(arr, item);
       return arr;
}

}
