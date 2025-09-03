package com.oms.user_service.service;

import com.oms.user_service.dto.LoginRequestDTO;
import com.oms.user_service.dto.LoginResponseDTO;
import com.oms.user_service.entity.OMSUser;
import com.oms.user_service.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public LoginResponseDTO getAccessToken(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));

        OMSUser OMSUser = (OMSUser) authentication.getPrincipal();
        String username = OMSUser.getUsername();

        return new LoginResponseDTO(username, jwtUtil.generateJWTToken(username));
    }
}
