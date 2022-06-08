package examPreparation.javaAdvancedExam19February2022.parrots;

public class Parrot {
    String name;
    String species;
    boolean available;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        available = true;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setAvailable() {
        this.available = !available;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Parrot (" + species + "): " + name;
    }
}
