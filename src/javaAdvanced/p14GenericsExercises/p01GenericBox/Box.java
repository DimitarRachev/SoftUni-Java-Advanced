package javaAdvanced.p14GenericsExercises.p01GenericBox;

public class Box<T> {
    T element;

    public Box(T element) {
        this.element = element;
    }


    @Override
    public String toString() {
        return String.format("%s: %s%n", element.getClass().getName(), element);
    }
}
