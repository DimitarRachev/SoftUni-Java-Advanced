package examPreparation.javaAdvancedRetakeExam13April2022.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public List<Egg> data;
    public String material;
    public int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (capacity > data.size()) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getColor().equals(color)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        int maxStrength = Integer.MIN_VALUE;
        Egg toReturn = null;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getStrength() > maxStrength) {
                maxStrength = data.get(i).getStrength();
                toReturn = data.get(i);
            }
        }
        return toReturn;
    }

    public Egg getEgg(String color) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getColor().equals(color)) {
                return data.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(material).append(" basket contains:").append(System.lineSeparator());
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i));
            if (i < data.size() - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
