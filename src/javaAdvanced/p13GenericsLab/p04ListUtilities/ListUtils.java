package javaAdvanced.p13GenericsLab.p04ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable> T getMin(List<T> list) {
        assertNotEmpty(list);
      return (T) Collections.min(list);
    }

    public static <T extends Comparable> T getMax(List<T> list) {
        assertNotEmpty(list);

        return (T) Collections.max(list);

    }

    private static<T> void assertNotEmpty(List<T>list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }
}
