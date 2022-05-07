package JavaAdvanced.p12DefiningClassesExercises.p08TOFIXFamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    String name;
    String birthDay;
    List<Person> parents;
    List<Person> childrens;

    public Person() {
        parents = new ArrayList<>();
        childrens = new ArrayList<>();
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildrens() {
        return childrens;
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public void setChildrens(List<Person> childrens) {
        this.childrens = childrens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) || Objects.equals(birthDay, person.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDay, parents, childrens);
    }

    public void purgeLists() {
        for (int i = 0; i < this.parents.size() - 1; i++) {
            Person first = parents.get(i);
            for (int j = i; j < parents.size() ; j++) {
                if (first.equals(parents.get(j))) {
                    parents.remove(j);
                    j--;
                }
            }
        }

        for (int i = 0; i < this.childrens.size() -1; i++) {
            Person first = childrens.get(i);
            for (int j = i; j < childrens.size() ; j++) {
                if (first.equals(childrens.get(j))) {
                    childrens.remove(j);
                    j--;
                }
            }
        }
    }
}
