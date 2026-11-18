package kz.baizhik.userservice.mappers;

import kz.baizhik.userservice.model.dto.UserResponseDTO;
import kz.baizhik.userservice.model.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.isEnabled()
        );
    }
}
