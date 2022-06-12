package javaAdvanced.p12DefiningClassesExercises.p09CatLady;

public class Cymric extends Cat{
    double furLenght;

    public Cymric(String name, double furLenght) {
        this.name = name;
        this.furLenght = furLenght;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", "Cymric", this.name, this.furLenght);
    }
}
