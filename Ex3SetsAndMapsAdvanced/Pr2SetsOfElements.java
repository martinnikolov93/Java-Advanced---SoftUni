package Ex3SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Pr2SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> setN = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            setN.add(input);
        }

        Set<Integer> setM = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            setM.add(input);
        }

        setN.retainAll(setM);

        System.out.println(setN.toString().replaceAll(",|\\[|\\]",""));

    }
}
