package com.example.autocrypt_assignment_test.model;

import com.example.autocrypt_assignment_test.dto.userdto.SignupRequestDto;
import com.example.autocrypt_assignment_test.utils.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_user", indexes = {
        @Index(name = "i_userName", columnList = "userName")
})
public class User extends Timestamped {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    public User(SignupRequestDto signupRequestDto){
        this.username = signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
        this.nickname = signupRequestDto.getNickname();
    }
}
