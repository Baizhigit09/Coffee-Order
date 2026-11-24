package kz.baizhik.serviceorder.exceptions;

public class DrinkNotFoundException extends RuntimeException {
    public DrinkNotFoundException(Long id) {
        super("Drink not found: " + id);
    }
}
