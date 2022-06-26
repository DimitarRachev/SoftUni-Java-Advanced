package exam.wokout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    private String type;
    private int exerciseCount;

    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exerciseCount > exercises.size()) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getName().equals(name) && exercises.get(i).getMuscle().equals(muscle)) {
                exercises.remove(i);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getName().equals(name) && exercises.get(i).getMuscle().equals(muscle)) {
                return exercises.get(i);
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(type).append(System.lineSeparator());
        sb.append(exercises.stream().map(Exercise::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}
