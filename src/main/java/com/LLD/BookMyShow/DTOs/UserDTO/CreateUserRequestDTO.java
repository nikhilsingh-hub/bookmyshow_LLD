package com.LLD.BookMyShow.DTOs.UserDTO;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private String name;
    private String email;
    private String mobile;
}
