package com.example.autocrypt_assignment_test.utils;

import com.example.autocrypt_assignment_test.dto.userdto.SignupRequestDto;
import com.example.autocrypt_assignment_test.exception.CustomException;
import com.example.autocrypt_assignment_test.exception.ErrorCode;
import com.example.autocrypt_assignment_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserUtil {
    private final UserRepository userRepository;

    @Autowired
    public UserUtil(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void signupValidate(SignupRequestDto signupRequestDto) throws IllegalArgumentException {
        if (userRepository.findByUsername(signupRequestDto.getUsername()).isPresent()) {
            throw new CustomException(ErrorCode.EXIST_USERNAME);
        }
        if (userRepository.findByNickname(signupRequestDto.getNickname()).isPresent()) {
            throw new CustomException(ErrorCode.EXIST_NICKNAME);
        }
        if (!Pattern.matches("^[ㄱ-ㅎ가-힣a-zA-Z0-9-_]{2,6}$", signupRequestDto.getNickname())) {
            throw new CustomException(ErrorCode.WRONG_VALUE_NICKNAME);
        }
        if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}", signupRequestDto.getPassword())) {
            throw new CustomException(ErrorCode.WRONG_VALUE_PASSWORD);
        }
    }
}
