package javaAdvanced.p12DefiningClassesExercises.p09CatLady;

public class Siamese extends Cat {
double earSize;

    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", "Siamese", this.name, this.earSize);
    }
}
