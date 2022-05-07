package JavaAdvanced.p12DefiningClassesExercises.p07Google;

public class Company {
    String name;
    String department;
    double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.name, this.department, this.salary);
    }
}
