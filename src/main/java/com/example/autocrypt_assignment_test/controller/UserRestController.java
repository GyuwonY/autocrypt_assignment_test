package com.example.autocrypt_assignment_test.controller;

import com.example.autocrypt_assignment_test.dto.userdto.SignupRequestDto;
import com.example.autocrypt_assignment_test.dto.userdto.SignupResponseDto;
import com.example.autocrypt_assignment_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto){

        return userService.signup(signupRequestDto);
    }
}
