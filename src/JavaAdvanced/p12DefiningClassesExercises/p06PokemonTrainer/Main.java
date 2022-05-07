package JavaAdvanced.p12DefiningClassesExercises.p06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();
        String line;
        while (!"Tournament".equals(line = scanner.nextLine())) {
            String[] input = line.split("\\s+");
            String trainer = input[0];
            String pokemonName = input[1];
            String element = input[2];
            int health = Integer.parseInt(input[3]);
            Pokemon current = new Pokemon(pokemonName, element, health);
            trainersMap.putIfAbsent(trainer, new Trainer(trainer, new ArrayList<>()));
            trainersMap.get(trainer).getPokemons().add(current);
        }

        String element;
        while (!"End".equals(element = scanner.nextLine())) {
            for (Map.Entry<String, Trainer> entry : trainersMap.entrySet()) {
                if (!entry.getValue().getPokemons().isEmpty() && entry.getValue().hasElement(element)) {
                    entry.getValue().receiveBadge();
                } else {
                    entry.getValue().takeDamage();
                }
            }
        }

        Map<String, Trainer> sorted = new LinkedHashMap<>();
        trainersMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((Comparator.comparingInt(Trainer::getNumberOfBadges)).reversed()))
                .forEach(e -> sorted.put(e.getKey(), e.getValue()));
        if (!sorted.isEmpty()) {
            sorted.forEach((key, value) -> System.out.println(key + " " + value.getNumberOfBadges() + " " + value.getNumberOfPokemons()));
        }
    }
}
