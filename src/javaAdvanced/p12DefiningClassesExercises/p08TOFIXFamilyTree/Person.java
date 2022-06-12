package javaAdvanced.p12DefiningClassesExercises.p08TOFIXFamilyTree;

import java.util.*;

public class Person implements Comparable<Person> {
    private String name;
    private String birthDay;
    private Set<Person> parents;
    private Set<Person> children;

    public Person(String name, String birthDay) {
        this();
        this.name = name;
        this.birthDay = birthDay;
    }

    public Person() {
        parents = new LinkedHashSet<>();
        children = new LinkedHashSet<>();
    }

    public Set<Person> getParents() {
        return parents;
    }


    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void addParent(Person p) {
        this.parents.add(p);
    }

    public void addChild(Person c) {
        this.children.add(c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(birthDay).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator());
        if (!parents.isEmpty()) {
            parents.forEach(person -> sb.append(person.getName()).append(" ").append(person.getBirthDay()).append(System.lineSeparator()));
        }

        sb.append("Children:").append(System.lineSeparator());
        if (!children.isEmpty()) {
            children.forEach(person -> sb.append(person.getName()).append(" ").append(person.getBirthDay()).append(System.lineSeparator()));
        }

        return sb.toString();
    }


    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
