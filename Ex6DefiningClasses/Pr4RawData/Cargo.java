package Ex6DefiningClasses.Pr4RawData;

public class Cargo {
    //<CargoWeight> <CargoType>

    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }
}
