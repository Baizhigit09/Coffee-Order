package kz.baizhik.serviceorder.model.dto;

import kz.baizhik.serviceorder.model.emun.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDTO(
        Long id,
        Long userId,
        OrderStatus status,
        BigDecimal unitPrice,
        LocalDateTime createdAt,
        List<OrderItemResponseDTO> items
) {
}
