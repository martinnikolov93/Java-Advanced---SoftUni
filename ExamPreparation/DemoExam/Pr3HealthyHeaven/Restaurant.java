package ExamPreparation.DemoExam.Pr3HealthyHeaven;

import java.util.*;

public class Restaurant {
    private String name;
    private Map<String, Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void add(Salad salad) {
        this.data.put(salad.getName(), salad);
    }

    public boolean buy(String name) {
        if (this.data.containsKey(name)) {
            this.data.remove(name);
            return true;
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        String healthiestSalad = "";
        int lowestCalories = Integer.MAX_VALUE;

        for (Salad salad : this.data.values()) {
            int currentCalories = salad.getTotalCalories();
            if (currentCalories < lowestCalories) {
                healthiestSalad = salad.getName();
                lowestCalories = currentCalories;
            }
        }
        return this.data.get(healthiestSalad);
    }

    public String generateMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append(String.format("%s have %d salads:",
                this.getName(), this.data.size()))
                .append(System.lineSeparator());

        for (Salad salad : this.data.values()) {
            menu.append(salad.toString()).append(System.lineSeparator());
        }
        return menu.toString().trim();
    }
}