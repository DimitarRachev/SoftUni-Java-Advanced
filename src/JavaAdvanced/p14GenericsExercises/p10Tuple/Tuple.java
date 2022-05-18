package JavaAdvanced.p14GenericsExercises.p10Tuple;

public class Tuple<E, T> {
   private E item1;
   private T item2;

    public Tuple(E item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public E getItem1() {
        return item1;
    }

    public void setItem1(E item1) {
        this.item1 = item1;
    }

    public T getItem2() {
        return item2;
    }

    public void setItem2(T item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return item1 + " -> " + item2;
    }
}
