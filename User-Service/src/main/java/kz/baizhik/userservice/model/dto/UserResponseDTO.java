package kz.baizhik.userservice.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@AllArgsConstructor
@Data
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private LocalDateTime createdAt;
    private boolean enabled;
}
