package Ex5FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Pr6PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stringLenght = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Predicate<String> checkLength = str -> str.length() <= stringLenght;

        names.stream().filter(checkLength).forEach(System.out::println);
    }
}
