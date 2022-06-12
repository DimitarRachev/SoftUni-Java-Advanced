package javaAdvanced.p12DefiningClassesExercises.p04RawData;

public class Car {
    String model;
    Engine engine;
    Cargo cargo;
    Tyres tyres;

    public Car(String model, Engine engine, Cargo cargo, Tyres tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
