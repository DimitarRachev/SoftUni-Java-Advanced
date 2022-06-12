package javaAdvanced.p14GenericsExercises.p07CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    List<T> elements;

    public CustomList() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }


    public T remove(int index) {
        return elements.remove(index);
    }

    public boolean contains(T element) {
//        for (T t : elements) {
//            if (t.compareTo(element) == 0) {
//                return true;
//            }
//        }
//        return false;
        return elements.contains(element);
    }


    public void swap(int index, int index1) {
//        T temp = elements.get(index);
//        elements.set(index, elements.get(index1));
//        elements.set(index1, temp);
        Collections.swap(elements, index, index1);
    }

    public int countGreaterThan(T value) {
//        int count = 0;
//        for (T t : this.elements) {
//            if (t.compareTo(value) > 0) {
//                count++;
//            }
//        }
//        return count;
        return (int) elements.stream().filter(e -> e.compareTo(value) > 0).count();
    }

    public T getMax() {

//        return (T) Collections.max(elements);
        return elements.stream().max((first, second) -> first.compareTo(second)).get();
    }

    public T getMin() {
//        return (T) Collections.min(elements);
    return elements.stream().min(Comparable::compareTo).get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : elements) {
            sb.append(t).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
