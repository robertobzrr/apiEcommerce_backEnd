package com.robertoapi.login_and_authentication_api.dtos;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
}
