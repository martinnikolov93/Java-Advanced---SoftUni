package ExamPreparation.DemoExam;

import java.util.Arrays;
import java.util.Scanner;

public class Pr1TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] garden = new char[n][];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            garden[i] = new char[input.length];

            for (int j = 0; j < input.length; j++) {
                garden[i][j] = input[j].charAt(0);
            }
        }

        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmedVegetables = 0;

        String input = "";

        while (!"End of Harvest".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" ");

            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);


            switch (command) {
                case "Harvest":

                    if (row >= garden.length || col >= garden[row].length){
                        continue;
                    }

                    char vegetable = garden[row][col];

                    switch (vegetable) {
                        case 'C':
                            carrots++;
                            break;
                        case 'P':
                            potatoes++;
                            break;
                        case 'L':
                            lettuce++;
                            break;
                    }

                    garden[row][col] = ' ';
                    break;
                case "Mole":
                    String direction = tokens[3];

                    harmedVegetables += moleEat(garden, row, col, direction);

                    break;
            }
        }

        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println(String.format("Carrots: %d\n" +
                "Potatoes: %d\n" +
                "Lettuce: %d\n" +
                "Harmed vegetables: %d\n", carrots, potatoes, lettuce, harmedVegetables));
    }

    //Eats vegetables and returns the count of eaten vegetables
    public static int moleEat(char[][] garden, int row, int col, String direction) {

        if (row >= garden.length || col >= garden[row].length) {
            return 0;
        }

        int harmedVegetables = 0;

        switch (direction) {
            case "up":

                for (int i = row; i >= 0; i -= 2) {
                    if (i >= garden[i].length) {
                        continue;
                    }
                    if (garden[i][col] == ' ') {
                        continue;
                    }
                    garden[i][col] = ' ';
                    harmedVegetables++;
                }
                break;

            case "down":
                for (int i = row; i <= garden.length; i += 2) {
                    if (i >= garden[i].length) {
                        break;
                    }
                    if (garden[i][col] == ' ') {
                        continue;
                    }
                    garden[i][col] = ' ';
                    harmedVegetables++;
                }
                break;

            case "left":
                for (int i = col; i >= 0; i -= 2) {
                    if (garden[row][i] == ' ') {
                        continue;
                    }
                    garden[row][i] = ' ';
                    harmedVegetables++;
                }
                break;

            case "right":
                for (int i = col; i <= garden[row].length; i += 2) {
                    if (garden[row][i] == ' ') {
                        continue;
                    }
                    garden[row][i] = ' ';
                    harmedVegetables++;
                }
                break;

        }


        return harmedVegetables;
    }
}
