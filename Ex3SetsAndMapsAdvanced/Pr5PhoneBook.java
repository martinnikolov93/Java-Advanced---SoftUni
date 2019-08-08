package Ex3SetsAndMapsAdvanced;

import java.util.*;

public class Pr5PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> phonebook = new HashMap<>();

        String input;
        while(!"search".equals(input = scanner.nextLine())){
            String[] inputArray = input.split("-");
            String name = inputArray[0];
            String phoneNumber = inputArray[1];

            phonebook.put(name,phoneNumber);
        }

        String name;
        while(!"stop".equals(name = scanner.nextLine())){

            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n",name);
            }
        }


    }
}
