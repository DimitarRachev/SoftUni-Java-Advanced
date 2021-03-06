package examPreparation.javaAdvancedRetakeExam17Dec2019.christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;


    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (data.size() < capacity) {
            data.add(present);

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

    public Present heaviestPresent() {
        Present heavy = new Present("", Double.MIN_VALUE, "");
        for (Present present : data) {
            if (present.getWeight() >= heavy.getWeight()) {
                heavy = present;
            }
        }
        return heavy;
    }

    public Present getPresent(String name) {
        for (Present present : data) {
            if (name.equals(present.getName())) {
                return present;
            }
        }
        return null;
    }

    public String report() {
        return color + " bag contains:" + System.lineSeparator()
                + data.stream().map(Present::toString).collect(Collectors.joining(System.lineSeparator()));
    }

}
