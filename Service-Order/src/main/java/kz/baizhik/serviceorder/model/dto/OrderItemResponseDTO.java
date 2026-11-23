package kz.baizhik.serviceorder.model.dto;

import java.math.BigDecimal;

public record OrderItemResponseDTO(
        Long drinkId, String drinkName, BigDecimal unitPrice,
        Integer quantity, BigDecimal lineTotal
) {}
