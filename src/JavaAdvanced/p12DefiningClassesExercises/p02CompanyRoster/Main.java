package JavaAdvanced.p12DefiningClassesExercises.p02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departments = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Employee employee = new Employee(input);
            String departmentName = input[3];
            departments.putIfAbsent(departmentName, new Department(departmentName));
            departments.get(departmentName).getEmployees().add(employee);
        }

//        Department maxPayingDep = getMaxPayingDep(departments);
        Department maxPayingDep = departments
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();
        System.out.println("Highest Average Salary: " + maxPayingDep.getName());
        System.out.println(maxPayingDep.getEmployeesAsString());
    }

    private static Department getMaxPayingDep(Map<String, Department> departments) {
        Department result = null;
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            if (result == null) {
                result = entry.getValue();
                continue;
            }
            if (entry.getValue().getAverageSalary() > result.getAverageSalary()) {
                result = entry.getValue();
            }
        }
        return result;
    }
}
