package javaAdvanced.p14GenericsExercises.p06GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    List<T> elements;

    public Box() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public int countGreater(T value) {
        int count = 0;
        for (T t : this.elements) {
            if (t.compareTo(value) > 0) {
                count++;
            }
        }
        return count;
    }
}
