package Ex5FunctionalProgramming;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

public class Pr3CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],Integer> minNumber = arr -> {

            int min = Arrays.stream(arr).min().getAsInt();

            return min;
        };

        System.out.println(minNumber.apply(numbers));
    }
}
