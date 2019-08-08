package ExamPreparation.SampleExam.Pr3SoftUniParking;
//package softUniParking;

import java.util.HashMap;
import java.util.List;

public class Parking {
    private HashMap<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.cars = new HashMap<>();
    }

    public String addCar (Car car) {
        String message = "";

        String registrationNumber = car.getRegistrationNumber();

        if (this.cars.containsKey(registrationNumber)){
            message = "Car with that registration number, already exists!";
        } else if (this.cars.size() >= capacity){
            message = "Parking is full!";
        } else {
            this.cars.put(registrationNumber,car);
            message = "Successfully added new car "+ car.getMake() + " " + car.getRegistrationNumber();
        }

        return message;
    }

    public String removeCar(String registrationNumber){
        String message = "";

        if (this.cars.containsKey(registrationNumber)){
            this.cars.remove(registrationNumber);
            message = "Successfully removed " + registrationNumber;
        } else {
            message = "Car with that registration number, doesn't exists!";
        }

        return message;
    }

    public Car getCar(String registrationNumber){
        Car car = this.cars.get(registrationNumber);

        return car;
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        for (String registrationNumber : registrationNumbers) {
                this.cars.remove(registrationNumber);
        }
    }

    public int getCount (){
        return this.cars.size();
    }
}
