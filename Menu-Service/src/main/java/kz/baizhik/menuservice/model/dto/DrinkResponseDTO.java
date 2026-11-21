package kz.baizhik.menuservice.model.dto;

import java.math.BigDecimal;

public record DrinkResponseDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        boolean available,
        Long categoryId,
        String categoryName
) {
}
