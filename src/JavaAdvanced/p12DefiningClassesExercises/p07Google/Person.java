package JavaAdvanced.p12DefiningClassesExercises.p07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    Company company;
    Car car;
    List<Pokemon> pokemons;
    List<Parent> parents;
    List<Child> children;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.car = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }


    public void printPerson() {
        System.out.println(this.name);
        System.out.println("Company:");
        if (company != null) {
            System.out.print(company);
        }
        System.out.println("Car:");
        if (car != null) {
            System.out.print(car);
        }
        System.out.println("Pokemon:");
        for (Pokemon pokemon : this.pokemons) {
            System.out.print(pokemon);
        }
        System.out.println("Parents:");
        for (Parent parent : this.parents) {
            System.out.print(parent);
        }
        System.out.println("Children:");
        for (Child child : this.children) {
            System.out.print(child);
        }


//
//                .append().append(System.lineSeparator())
//                .append(this.parents).append(System.lineSeparator())
//                .append().append(System.lineSeparator())
//                .append(this.children).append(System.lineSeparator());
//        return sb.toString();
    }
}
