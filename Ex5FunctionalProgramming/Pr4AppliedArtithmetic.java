package Ex5FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pr4AppliedArtithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();

        Consumer<ArrayList<Integer>> printer = arr -> arr
                .forEach(num -> System.out.print(num + " "));

        Function<ArrayList<Integer>,ArrayList<Integer>> increment =
                arr -> arr.stream().map(e -> ++e)
                        .collect(Collectors.toCollection(ArrayList::new));

        Function<ArrayList<Integer>,ArrayList<Integer>> multiply =
                arr -> arr.stream().map(e -> e *= 2)
                        .collect(Collectors.toCollection(ArrayList::new));

        Function<ArrayList<Integer>,ArrayList<Integer>> subtract =
                arr -> arr.stream().map(e -> --e)
                        .collect(Collectors.toCollection(ArrayList::new));

        while(!command.equals("end")){

            switch (command){
                case "add":
                    numbers = increment.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }


    }
}
