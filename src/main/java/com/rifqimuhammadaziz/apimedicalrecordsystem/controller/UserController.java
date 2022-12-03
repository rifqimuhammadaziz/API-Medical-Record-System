package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.User;
import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.UserDTO;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.UserRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.OK);
    }
}
