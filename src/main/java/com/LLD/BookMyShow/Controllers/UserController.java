package com.LLD.BookMyShow.Controllers;

import com.LLD.BookMyShow.DTOs.UserDTO.CreateUserRequestDTO;
import com.LLD.BookMyShow.DTOs.UserDTO.UserResponseDTO;
import com.LLD.BookMyShow.Models.User;
import com.LLD.BookMyShow.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody CreateUserRequestDTO request) {
        User user = userService.createUser(request.getName(), request.getEmail(), request.getMobile());
        return convertToDTO(user);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        if (user == null) {
            return null;
        }
        return convertToDTO(user);
    }

    private UserResponseDTO convertToDTO(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setMobile(user.getMobile());
        return response;
    }
}
