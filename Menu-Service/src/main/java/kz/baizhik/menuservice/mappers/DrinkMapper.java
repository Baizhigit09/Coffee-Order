package kz.baizhik.menuservice.mappers;

import kz.baizhik.menuservice.model.dto.DrinkResponseDTO;
import kz.baizhik.menuservice.model.entites.Drink;
import org.springframework.stereotype.Component;

@Component
public class DrinkMapper {
    public DrinkResponseDTO toResponse(Drink drink) {
        return new DrinkResponseDTO(
                drink.getId(),
                drink.getName(),
                drink.getDescription(),
                drink.getPrice(),
                drink.isAvailable(),
                drink.getCategory().getId(),
                drink.getCategory().getName()
        );
    }
}
