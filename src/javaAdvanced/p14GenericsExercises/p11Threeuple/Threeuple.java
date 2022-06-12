package javaAdvanced.p14GenericsExercises.p11Threeuple;

public class Threeuple<E, T, S> {
   private E item1;
   private T item2;
   private S item3;

    public Threeuple(E item1, T item2, S item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
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

    public S getItem3() {
        return item3;
    }

    public void setItem3(S item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return item1 + " -> " + item2 + " -> " + item3;
    }
}
