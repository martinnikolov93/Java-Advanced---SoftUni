package Ex6DefiningClasses.Pr4RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tires;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire getTires() {
        return tires;
    }

    public void setTires(Tire tires) {
        this.tires = tires;
    }
}
