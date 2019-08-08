package Ex3SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr6AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> resources = new LinkedHashMap<>();

        String resource;
        while(!"stop".equals(resource = scanner.nextLine())){
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource,quantity);
            } else {
                resources.put(resource,resources.get(resource) + quantity);
            }
        }

        for (var res : resources.entrySet()) {
            System.out.printf("%s -> %d%n",res.getKey(),res.getValue());
        }
    }
}
