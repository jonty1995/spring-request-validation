package com.spring.api.service;

import com.spring.api.dto.UserRequest;
import com.spring.api.entity.User;
import com.spring.api.exception.UserNotFoundException;
import com.spring.api.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUser(int userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findById(userId);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        throw new UserNotFoundException("user not found with id : "+userId);

    }
}
