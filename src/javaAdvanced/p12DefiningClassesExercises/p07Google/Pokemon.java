package javaAdvanced.p12DefiningClassesExercises.p07Google;

public class Pokemon {
    String name;
    String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name + " " + this.type + System.lineSeparator();
    }
}
