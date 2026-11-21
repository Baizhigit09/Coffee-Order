package kz.baizhik.menuservice.model.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record DrinkRequestDTO(
        @NotBlank @Size(max = 150) String name,
        @Size(max = 500) String description,
        @NotNull @DecimalMin(value = "0.01")
        @Digits(integer = 8, fraction = 2)
        BigDecimal price,
        @NotNull Long categoryId,
        Boolean available

) {
}
