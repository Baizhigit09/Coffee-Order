package kz.baizhik.serviceorder.model.dto;

import java.math.BigDecimal;

public record DrinkDTO(
        Long id,
        String name,
        BigDecimal price,
        boolean available
) {
}
