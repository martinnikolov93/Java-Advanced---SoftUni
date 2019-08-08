package Ex3SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Pr1UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();

            usernames.add(input);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
