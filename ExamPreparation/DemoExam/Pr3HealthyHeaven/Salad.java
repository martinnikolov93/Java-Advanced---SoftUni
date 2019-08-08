package ExamPreparation.DemoExam.Pr3HealthyHeaven;

import java.util.ArrayList;

public class Salad {
    private String name;
    private ArrayList<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        int sum = 0;

        sum = this.products.stream().map(e -> e.getCalories()).mapToInt(Integer::intValue).sum();

        return sum;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product){
        this.products.add(product);
    }

    public String getProducts (){
        String products = "";

        for (Vegetable product : this.products) {
            products += "\n" + product.toString();
        }

        return products;
    }

    @Override
    public String toString() {
        int produceCount = this.getProductCount();
        int calories = this.getTotalCalories();
        StringBuilder saladInfo = new StringBuilder();

        saladInfo.append(String.format("* Salad %s is %d calories and have %d products:"
                , this.getName(), calories, produceCount)).append(System.lineSeparator());

        for (Vegetable vegetable : this.products) {
            saladInfo.append(vegetable.toString()).append(System.lineSeparator());
        }
        return saladInfo.toString().trim();
    }
}
