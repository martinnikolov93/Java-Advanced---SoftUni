package ExamPreparation.DemoExam;

import java.util.*;
import java.util.stream.Collectors;

public class Pr2MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetableQueue = new ArrayDeque<>();

        ArrayDeque<Integer> saladStack = new ArrayDeque<>();

        List<String> vegetables = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<Integer> salads = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (String s : vegetables) {
            vegetableQueue.offer(s);
        }

        for (Integer i : salads) {
            saladStack.push(i);
        }

        while (!saladStack.isEmpty() && !vegetableQueue.isEmpty()) {

            String currentVegetable = vegetableQueue.poll();
            vegetables.remove(0);

            Integer currentSaladCalories = saladStack.peek();

            Integer salad = salads.get(salads.size() - 1);

            boolean isStarted = false;
            if (currentSaladCalories < salad){
                isStarted = true;
            }

            saladStack.pop();

            int currentVegCalories = 0;

            switch (currentVegetable){
                case "tomato":
                    currentVegCalories = 80;
                    break;

                case "carrot":
                    currentVegCalories = 136;
                    break;

                case "lettuce":
                    currentVegCalories = 109;
                    break;

                case "potato":
                    currentVegCalories = 215;
                    break;
            }


            currentSaladCalories -= currentVegCalories;

            saladStack.push(currentSaladCalories);

            if (currentSaladCalories <= 0) {

                System.out.print(salads.get(salads.size() - 1) + " ");
                salads.remove(salads.get(salads.size() - 1));

                saladStack.pop();

                if (saladStack.isEmpty() || vegetableQueue.isEmpty()){
                    break;
                }
            }

            if (saladStack.isEmpty() || vegetableQueue.isEmpty()){

                if (isStarted){
                    System.out.print(salads.get(salads.size() - 1) + " ");
                    salads.remove(salads.get(salads.size() - 1));

                    saladStack.pop();
                }

                break;
            }



        }

        System.out.println();

        if (saladStack.isEmpty()){
            for (String vegetable : vegetables) {
                System.out.print(vegetable + " ");
            }
        } else if (vegetableQueue.isEmpty()){
            for (int i = salads.size() - 1; i >= 0; i--) {
                System.out.print(salads.get(i) + " ");
            }
        }

    }
}
