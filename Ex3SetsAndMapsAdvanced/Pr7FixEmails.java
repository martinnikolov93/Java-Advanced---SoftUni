package Ex3SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr7FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;

        Map<String, String> emails = new LinkedHashMap<>();

        while (!"stop".equals(name = scanner.nextLine())) {
            String email = scanner.nextLine();
            //us, uk, com
           if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
               emails.putIfAbsent(name,email);
           }
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.println(String.format("%s -> %s",entry.getKey(),entry.getValue()));
        }
    }
}
