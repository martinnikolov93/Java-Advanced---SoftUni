package Ex5FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Pr5ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        
        int divisor = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        numbers.removeIf(n -> n % divisor == 0);

        Consumer<List<Integer>> printer = list -> list.forEach( e -> System.out.print(e + " "));

        printer.accept(numbers);
    }
}
