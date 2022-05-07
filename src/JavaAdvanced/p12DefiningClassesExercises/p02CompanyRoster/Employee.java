package JavaAdvanced.p12DefiningClassesExercises.p02CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String[] input) {
        String name = input[0];
        double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String department = input[3];
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = -1;
        this.email = "n/a";
        if (input.length == 5) {
            String s = input[4];
            try {
                this.age = Integer.parseInt(s);
            } catch (Exception E) {
                this.email = s;
            }
        } else if (input.length == 6) {
            String email = input[4];
            int age = Integer.parseInt(input[5]);
            this.email = email;
            this.age = age;
        }
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
