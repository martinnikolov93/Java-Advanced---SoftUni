package Ex5FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pr7FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>,Integer> getSmallestElement =
                list -> {
                    int minElement = Integer.MAX_VALUE;
                    int minElementIndex = 0;
                    int index = 0;
                    for (Integer num : list) {
                        if (num <= minElement){
                            minElement = num;
                            minElementIndex = index;
                        }

                        index++;
                    }

                    return minElementIndex;
                };

        System.out.println(getSmallestElement.apply(numbers));
    }
}
