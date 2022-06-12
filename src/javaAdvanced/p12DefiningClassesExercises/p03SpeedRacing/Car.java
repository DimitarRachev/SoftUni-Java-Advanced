package javaAdvanced.p12DefiningClassesExercises.p03SpeedRacing;

public class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelCostFor1km;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }


    public boolean drive(Double km) {
        if (fuelAmount < km * fuelCostFor1km) {
            return false;
        }
        fuelAmount -= km * fuelCostFor1km;
        distanceTraveled += km;
        return true;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
