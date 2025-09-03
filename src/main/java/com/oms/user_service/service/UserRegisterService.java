package com.oms.user_service.service;

import com.oms.user_service.dto.CreateUserRequestDTO;
import com.oms.user_service.dto.CreateUserResponseDTO;
import com.oms.user_service.entity.OMSUser;
import com.oms.user_service.repository.UserRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserRegisterService {

    private final UserRegisterRepository userRegisterRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserResponseDTO register(CreateUserRequestDTO createUserRequestDTO) {
        OMSUser user = new OMSUser();
        user.setUsername(createUserRequestDTO.getUsername());
        user.setEmail(createUserRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(createUserRequestDTO.getPassword()));
        user.setRole(createUserRequestDTO.getRole());
        user.setCreated_at(LocalDate.now());
        user.setUpdated_at(LocalDate.now());

        OMSUser savedUser = userRegisterRepository.save(user);

        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
        responseDTO.setId(savedUser.getId());
        responseDTO.setMessage("User registered successfully");
        return responseDTO;
    }
}
