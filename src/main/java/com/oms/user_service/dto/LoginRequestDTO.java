package com.oms.user_service.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String username;

    private String password;
}
