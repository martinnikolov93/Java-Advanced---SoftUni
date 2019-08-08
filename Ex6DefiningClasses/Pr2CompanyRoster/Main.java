package Ex6DefiningClasses.Pr2CompanyRoster;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String department = tokens[3];

            Employee employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2]);

            if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    employee.setAge(Integer.parseInt(tokens[4]));
                } else {
                    employee.setEmail(tokens[4]);
                }
            } else if (tokens.length == 6) {
                employee.setEmail(tokens[4]);
                employee.setAge(Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(department)) {
                departments.put(department, new Department());
            }

            departments.get(department).addEmployee(employee);
        }

        Map.Entry<String, Department> highestAvgSalary = departments.entrySet().stream()
                .sorted((f, s) -> {
                    int result = 0;
                    if (s.getValue().getAverageSalary() > f.getValue().getAverageSalary()) {
                        result = 1;
                    } else if (s.getValue().getAverageSalary() < f.getValue().getAverageSalary()) {
                        result = -1;
                    }
                    return result;
                }).findFirst()
                .get();

        System.out.println(String.format("Highest Average Salary: %s", highestAvgSalary.getKey()));

        highestAvgSalary.getValue().getEmployees().stream().sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary())).forEach(employee -> {
            System.out.println(String.format("%s %.2f %s %d",
                    employee.getName(),
                    employee.getSalary(),
                    employee.getEmail(),
                    employee.getAge()));
        });

    }
}

