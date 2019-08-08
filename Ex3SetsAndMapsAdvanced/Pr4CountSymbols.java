package Ex3SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr4CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character,Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol,1);
            } else {
                symbolsCount.put(symbol,symbolsCount.get(symbol) + 1);
            }
        }

        for (var keyValuePair : symbolsCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", keyValuePair.getKey(),keyValuePair.getValue());
        }
    }
}
