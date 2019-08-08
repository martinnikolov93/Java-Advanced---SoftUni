package Ex3SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Pr3PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        while (n-- > 0) {
           String[] inputElements = scanner.nextLine().split("\\s+");

           elements.addAll(Arrays.asList(inputElements));
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
