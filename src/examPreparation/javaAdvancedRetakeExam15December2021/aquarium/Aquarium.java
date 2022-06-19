package examPreparation.javaAdvancedRetakeExam15December2021.aquarium;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Aquarium {
    private Map<String, Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        fishInPool = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (capacity > fishInPool.size()) {
            fishInPool.putIfAbsent(fish.getName(), fish);
        }
    }

    public boolean remove(String name) {
        return fishInPool.remove(name) != null;
    }

    public Fish findFish(String name) {
        return fishInPool.get(name);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aquarium: ").append(name).append(" ^ Size: ").append(size).append(System.lineSeparator())
                .append(fishInPool.values().stream().map(Fish::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}
