package Ex5FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Pr1ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = System.out::println;

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printer);

    }
}
