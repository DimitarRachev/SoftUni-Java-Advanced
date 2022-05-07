package JavaAdvanced.p12DefiningClassesExercises.p05CarSalesman;

public class Engine {
    private String  model;
    private int power;
    private String displacement;
    String efficiency;

    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString(){
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%n", this.model, this.power, this. displacement, this.efficiency);
    }
}
