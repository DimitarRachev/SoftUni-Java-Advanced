package javaAdvanced.p13GenericsLab.p01JarofT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
   private Deque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<T>();
    }

   public void add(T element) {
        this.elements.push(element);
    }

    public T remove() {
    return this.elements.pop();
    }
}
