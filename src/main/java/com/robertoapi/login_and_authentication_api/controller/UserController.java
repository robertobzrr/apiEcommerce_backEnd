package com.robertoapi.login_and_authentication_api.controller;

import com.robertoapi.login_and_authentication_api.dtos.UserRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.UserResponseDTO;
import com.robertoapi.login_and_authentication_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

//-----------------------------------------------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequestDTO userDTO){
        userService.createUser(userDTO);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDTO> findAllUsers(){
        return userService.findAllUsers();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserResponseDTO> findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserById(@PathVariable Long id, @RequestBody UserRequestDTO updateUserDTO){
        userService.updateUserById(id, updateUserDTO);
    }



}
