package Exceptions;

public class CarAlreadyExists extends Exception {
    public CarAlreadyExists(String message) {
        super("Car "+ message+ " already exists!");
    }
}
