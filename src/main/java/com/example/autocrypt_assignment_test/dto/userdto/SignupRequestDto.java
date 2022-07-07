package com.example.autocrypt_assignment_test.dto.userdto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignupRequestDto {
    private String username;
    private String password;
    private String nickname;
}
