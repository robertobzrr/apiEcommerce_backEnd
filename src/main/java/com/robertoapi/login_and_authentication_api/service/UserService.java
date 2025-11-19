package com.robertoapi.login_and_authentication_api.service;
import com.robertoapi.login_and_authentication_api.dtos.UserRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.UserResponseDTO;
import com.robertoapi.login_and_authentication_api.model.User;
import com.robertoapi.login_and_authentication_api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

//------------------------------------------------------------------------------------------
//CRUD

    public void createUser(UserRequestDTO userDTO){
        User user = toEntity(userDTO);
        userRepository.save(user);
    }


    public List<UserResponseDTO> findAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public Optional<UserResponseDTO> findUserById(Long id){
        return userRepository.findById(id)
                .map(this::toResponseDTO);
    }


    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }


    public void updateUserById(Long id, UserRequestDTO updateUserDTO){
        Optional<User> userDB = userRepository.findById(id);

        if(userDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        else{
            User editUser = userDB.get();

            editUser.setName(updateUserDTO.getName());
            editUser.setEmail(updateUserDTO.getEmail());
            editUser.setPassword(updateUserDTO.getPassword());

            userRepository.save(editUser);
        }
    }


//------------------------------------------------------------------------------------------
//DTOs

    private User toEntity(UserRequestDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCart(userDTO.getCart());
        user.setOrders(userDTO.getOrders());

        return user;
    }


    private UserResponseDTO toResponseDTO(User user){
        UserResponseDTO respDTO = new UserResponseDTO();
        respDTO.setName(user.getName());
        respDTO.setEmail(user.getEmail());

        return respDTO;
    }


}
