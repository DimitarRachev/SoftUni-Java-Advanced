package examPreparation.javaAdvancedRetakeExam17Dec2019.christmas;

import java.text.DecimalFormat;

public class Present {

    private String name;
    private double weight;
    private String gender;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Present(String name, double weight, String gender) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Present %s (%s) for a %s", name, df.format(weight), gender);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
