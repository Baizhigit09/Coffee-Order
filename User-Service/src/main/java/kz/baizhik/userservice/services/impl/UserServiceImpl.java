package kz.baizhik.userservice.services.impl;

import jakarta.transaction.Transactional;
import kz.baizhik.userservice.exceptions.EmailAlreadyExistsException;
import kz.baizhik.userservice.exceptions.InvalidCredentialsException;
import kz.baizhik.userservice.exceptions.UserNotFoundException;
import kz.baizhik.userservice.model.Role;
import kz.baizhik.userservice.model.dto.AuthResponseDTO;
import kz.baizhik.userservice.model.dto.UserDTO;
import kz.baizhik.userservice.model.dto.UserLoginDTO;
import kz.baizhik.userservice.model.dto.UserResponseDTO;
import kz.baizhik.userservice.model.entities.User;
import kz.baizhik.userservice.repositories.UserRepository;
import kz.baizhik.userservice.security.JwtService;
import kz.baizhik.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    @Transactional
    public UserResponseDTO register(UserDTO registerRequest) {
        String email = registerRequest.getEmail().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException(email);
        }

        User user = new User();
        user.setFullName(registerRequest.getFullName().trim());
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.USER);
        user.setEnabled(true);

        try{
            return toResponse(userRepository.saveAndFlush(user));}
        catch (DataIntegrityViolationException e){
            throw new EmailAlreadyExistsException(email);
        }
    }

    @Override
    @Transactional
    public AuthResponseDTO login(UserLoginDTO loginRequest) {
        String email = normalizeEmail(loginRequest.getEmail());

        User user = userRepository.findByEmail(email)
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())
                || !user.isEnabled()) {
            throw new InvalidCredentialsException();
        }
        return new AuthResponseDTO(jwtService.generateToken(user), toResponse(user));
    }

    @Override
    public UserResponseDTO getById(Long id) {
        return userRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(()->new UserNotFoundException(id));
        }



    private String normalizeEmail(String email) {
        return email.trim().toLowerCase();
    }

    private UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.isEnabled()
        );
    }


}
