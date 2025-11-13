package com.robertoapi.login_and_authentication_api.service;
import com.robertoapi.login_and_authentication_api.model.User;
import com.robertoapi.login_and_authentication_api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

//------------------------------------------------------------------------------------------

    public void createUser(User user){
        userRepository.save(user);
    }


    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }


    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }


    public void updateUserById(Long id, User updateUser){
        Optional<User> userDB = findUserById(id);

        if(userDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        else{
            User editUser = userDB.get();

            editUser.setUsername(updateUser.getUsername());
            editUser.setPassword(updateUser.getPassword());

            userRepository.save(editUser);
        }
    }


}
