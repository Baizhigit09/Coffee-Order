package kz.baizhik.userservice.controllers;

import kz.baizhik.userservice.model.dto.UserResponseDTO;
import kz.baizhik.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/me")
    public ResponseEntity<UserResponseDTO> me(@AuthenticationPrincipal Long userId) {
        return ResponseEntity.ok(userService.getById(userId));
    }
}
