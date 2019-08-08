package Ex1StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex3MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String command = input[0];
            switch (command) {
                case "1":
                    int number = Integer.parseInt(input[1]);
                    numbersStack.push(number);
                    break;
                case "2":
                    numbersStack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbersStack));
                    break;
            }
        }
    }
}
