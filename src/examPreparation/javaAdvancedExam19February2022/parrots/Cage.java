package examPreparation.javaAdvancedExam19February2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    String name;
    int capacity;
    List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (capacity > data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name) && data.get(i).isAvailable()) {
                data.get(i).setAvailable();
                return data.get(i);
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> forSale = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getSpecies().equals(species) && data.get(i).isAvailable()) {
                forSale.add(data.get(i));
            }
        }
        return forSale;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(name).append(":").append(System.lineSeparator());
        for (int i = 0; i < data.size(); i++) {
            Parrot parrot = data.get(i);
            if (parrot.isAvailable()) {
                sb.append(parrot.toString());
            }
            if (i < data.size() - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
