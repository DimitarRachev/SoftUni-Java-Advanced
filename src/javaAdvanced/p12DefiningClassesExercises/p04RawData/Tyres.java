package javaAdvanced.p12DefiningClassesExercises.p04RawData;

import java.util.List;

public class Tyres {
    List<Tyre> tyres;

    public Tyres(List<Tyre> tyres) {
        this.tyres = tyres;
    }

    public boolean haveLowTyre() {
        for (Tyre tyre : tyres) {
            if (tyre.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }
}
