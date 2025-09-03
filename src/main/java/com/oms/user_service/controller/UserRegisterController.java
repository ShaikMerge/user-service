package com.oms.user_service.controller;


import com.oms.user_service.dto.CreateUserRequestDTO;
import com.oms.user_service.dto.CreateUserResponseDTO;
import com.oms.user_service.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class UserRegisterController {

        private final UserRegisterService userRegisterService;

        @PostMapping("/users/register")
        private CreateUserResponseDTO registerUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
            return userRegisterService.register(createUserRequestDTO);
        }


        @GetMapping("/test")
        private String test() {
            return "Working JWT";
        }

}
