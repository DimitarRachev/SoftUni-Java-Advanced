package JavaAdvanced.p12DefiningClassesExercises.p06PokemonTrainer;

import java.util.List;

public class Trainer {
    private final String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
        this.numberOfBadges = 0;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public int getNumberOfPokemons(){
        return this.pokemons.size();
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public boolean hasElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void receiveBadge() {
            this.numberOfBadges += 1;
    }

    public void takeDamage() {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).isDead()) {
                pokemons.remove(i--);
            }
        }
    }
}
