package kz.baizhik.userservice.controllers;


import jakarta.validation.Valid;
import kz.baizhik.userservice.model.dto.AuthResponseDTO;
import kz.baizhik.userservice.model.dto.UserDTO;
import kz.baizhik.userservice.model.dto.UserLoginDTO;
import kz.baizhik.userservice.model.dto.UserResponseDTO;
import kz.baizhik.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(userDTO));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return ResponseEntity.ok(userService.login(userLoginDTO));
    }

}
