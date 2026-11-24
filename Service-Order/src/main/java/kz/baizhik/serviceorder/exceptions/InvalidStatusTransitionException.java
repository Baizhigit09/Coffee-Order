package kz.baizhik.serviceorder.exceptions;

import kz.baizhik.serviceorder.model.emun.OrderStatus;

public class InvalidStatusTransitionException extends RuntimeException {
    public InvalidStatusTransitionException(OrderStatus from, OrderStatus to) {
        super("Invalid status transition from " + from + " to " + to);
    }
}
