package kz.baizhik.serviceorder.model.dto;

import jakarta.validation.constraints.NotNull;
import kz.baizhik.serviceorder.model.emun.OrderStatus;

public record StatusUpdateRequestDTO(
        @NotNull
        OrderStatus status
) {
}
