package kz.baizhik.userservice.model.dto;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String email;
    private String password;
}
