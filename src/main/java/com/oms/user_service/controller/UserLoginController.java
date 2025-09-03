package com.oms.user_service.controller;

import com.oms.user_service.dto.LoginRequestDTO;
import com.oms.user_service.dto.LoginResponseDTO;
import com.oms.user_service.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserLoginController {

    private final AuthenticationService authenticationService;

    @PostMapping("/users/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return authenticationService.getAccessToken(loginRequestDTO);
    }
}
