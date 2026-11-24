package kz.baizhik.serviceorder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleOrderNotFound(OrderNotFoundException ex) {
        return error(HttpStatus.NOT_FOUND, ex); // 404
    }

    @ExceptionHandler(DrinkNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDrinkNotFound(DrinkNotFoundException ex) {
        return error(HttpStatus.UNPROCESSABLE_ENTITY, ex);
    }

    @ExceptionHandler(DrinkNotAvailableException.class)
    public ResponseEntity<Map<String, String>> handleNotAvailable(DrinkNotAvailableException ex) {
        return error(HttpStatus.CONFLICT, ex); // 409
    }

    @ExceptionHandler(InvalidStatusTransitionException.class)
    public ResponseEntity<Map<String, String>> handleTransition(InvalidStatusTransitionException ex) {
        return error(HttpStatus.CONFLICT, ex); // 409
    }

    @ExceptionHandler(MenuServiceUnavailableException.class)
    public ResponseEntity<Map<String, String>> handleMenuDown(MenuServiceUnavailableException ex) {
        return error(HttpStatus.SERVICE_UNAVAILABLE, ex); // 503
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors); // 400
    }

    private ResponseEntity<Map<String, String>> error(HttpStatus status, Exception ex) {
        return ResponseEntity.status(status).body(Map.of("error", ex.getMessage()));
    }
}
