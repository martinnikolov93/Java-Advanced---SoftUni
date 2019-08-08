package Ex6DefiningClasses.Pr2CompanyRoster;

/*name, salary, position, department, email and age. The name, salary, position and department are mandatory while the rest are optional.*/

import java.util.List;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = "n/a";
        this.age = -1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }
}
