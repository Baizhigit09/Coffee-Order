package kz.baizhik.menuservice.exceptions;

public class DrinkNotFoundException extends RuntimeException {
    public DrinkNotFoundException(Long id) {
        super("Could not find drink with id " + id);
    }


}
