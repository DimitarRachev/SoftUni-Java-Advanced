package javaAdvanced.p12DefiningClassesExercises.p02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public double getAverageSalary() {
        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getEmployeesAsString() {
        StringBuilder temp = new StringBuilder();

        this.employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> temp.append(String.format("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge())));
//    this.employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(e -> temp.append(String.format("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge())));
        return temp.toString();
    }
}
