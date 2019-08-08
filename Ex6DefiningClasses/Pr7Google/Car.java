package Ex6DefiningClasses.Pr7Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public Car(){
        this.model = "";
        this.speed = -1;
    }

    @Override
    public String toString() {
        return this.model.equals("") ? "Car: \r\n" : String.format("Car: %n%s %d",this.model,this.speed);
    }
}
