package kz.baizhik.serviceorder.exceptions;

public class MenuServiceUnavailableException extends RuntimeException {
    public MenuServiceUnavailableException(Throwable cause){
        super(cause);
    }
}
