package kz.baizhik.serviceorder.exceptions;

public class DrinkNotAvailableException extends RuntimeException {
    public DrinkNotAvailableException(String name) {
        super("Order not found: " + name);
    }
}
