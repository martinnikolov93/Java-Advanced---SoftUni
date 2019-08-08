package Ex6DefiningClasses.Pr4RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            /*"<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>*/

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Car car = new Car(model);

            Engine engine = new Engine(engineSpeed,enginePower);
            car.setEngine(engine);

            Cargo cargo = new Cargo(cargoWeight,cargoType);
            car.setCargo(cargo);

            Tire tires = new Tire(tire1Pressure,tire1Age,tire2Pressure,tire2Age,tire3Pressure,tire3Age,tire4Pressure,tire4Age);
            car.setTires(tires);

            cars.add(car);
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")){
            cars.stream()
                    .filter(e -> e.getCargo().getCargoType().equals("fragile"))
                    .filter(e -> e.getTires().isTirePressureUnderOne())
                    .forEach(e -> System.out.println(e.getModel()));
        } else if (cargoType.equals("flamable")){
            cars.stream()
                    .filter(e -> e.getCargo().getCargoType().equals("flamable"))
                    .filter(e -> e.getEngine().getEnginePower() > 250)
                    .forEach(e -> System.out.println(e.getModel()));
        }
    }
}
