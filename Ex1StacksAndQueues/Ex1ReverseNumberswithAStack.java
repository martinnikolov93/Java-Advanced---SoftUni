package Ex1StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex1ReverseNumberswithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        for (int i = 0; i < input.length; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
