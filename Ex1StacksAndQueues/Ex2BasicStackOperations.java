package Ex1StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex2BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int stackSize = Integer.parseInt(input[0]);
        int numbersToPop = Integer.parseInt(input[1]);
        int numberToCheck = Integer.parseInt(input[2]);

        String[] stackNumbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < stackSize; i++) {
            int number = Integer.parseInt(stackNumbers[i]);
            stack.push(number);
        }

        for (int i = 0; i < numbersToPop; i++) {
            if (stack.size() == 0) {
                break;
            }
            stack.pop();
        }

        if (stack.contains(numberToCheck)) {
            System.out.println("true");
        } else {
            if (stack.size() == 0) {
                System.out.println("0");
            } else {
                System.out.println(Collections.min(stack));
            }
        }

    }
}
