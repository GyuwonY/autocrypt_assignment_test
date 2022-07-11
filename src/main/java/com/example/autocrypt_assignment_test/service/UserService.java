package com.example.autocrypt_assignment_test.service;

import com.example.autocrypt_assignment_test.dto.userdto.SignupRequestDto;
import com.example.autocrypt_assignment_test.dto.userdto.SignupResponseDto;
import com.example.autocrypt_assignment_test.model.User;
import com.example.autocrypt_assignment_test.repository.UserRepository;
import com.example.autocrypt_assignment_test.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserUtil userUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserUtil userUtil, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userUtil = userUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public ResponseEntity<SignupResponseDto> signup(SignupRequestDto signupRequestDto){
        userUtil.signupValidate(signupRequestDto);
        signupRequestDto.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        userRepository.save(new User(signupRequestDto));

        return new ResponseEntity<>(new SignupResponseDto("회원가입이 완료되었습니다."), HttpStatus.OK);
    }

}
