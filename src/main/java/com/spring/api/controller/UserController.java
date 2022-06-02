package com.spring.api.controller;

import com.spring.api.dto.UserRequest;
import com.spring.api.entity.User;
import com.spring.api.exception.UserNotFoundException;
import com.spring.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> fetchAll() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<User> fetchUser(@PathVariable int id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);

    }


}
