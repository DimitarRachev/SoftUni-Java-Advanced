package javaAdvanced.p13GenericsLab.p03GenericScale;

public class Scale<T extends Comparable> {
    T left;
    T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T TgetHeavier() {
        int n = left.compareTo(right);
        if (n == 0) {
            return null;
        } else if (n > 0) {
            return left;
        }
        return right;
    }
}
