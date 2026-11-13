package kz.baizhik.userservice.services;

import kz.baizhik.userservice.model.dto.AuthResponseDTO;
import kz.baizhik.userservice.model.dto.UserDTO;
import kz.baizhik.userservice.model.dto.UserLoginDTO;
import kz.baizhik.userservice.model.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO register(UserDTO registerRequest);

    AuthResponseDTO login(UserLoginDTO loginRequest);

    UserResponseDTO getById(Long id);
}
