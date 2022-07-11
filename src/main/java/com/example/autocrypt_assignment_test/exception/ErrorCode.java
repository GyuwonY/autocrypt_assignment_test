package com.example.autocrypt_assignment_test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXIST_USERNAME(HttpStatus.BAD_REQUEST.value(), "1","중복된 아이디가 존재합니다."),
    EXIST_NICKNAME(HttpStatus.BAD_REQUEST.value(), "2","중복된 닉네임이 존재합니다."),
    WRONG_VALUE_NICKNAME(HttpStatus.BAD_REQUEST.value(), "3","닉네임은 특수문자를 제외한 2~6자만 사용이 가능합니다."),
    WRONG_VALUE_PASSWORD(HttpStatus.BAD_REQUEST.value(), "4","비밀번호는 대소문자와 숫자, 특수문자를 포함한 8글자 이상 사용이 가능합니다."),
    WRONG_BOARDID(HttpStatus.BAD_REQUEST.value(), "5","자신이 작성한 게시글만 수정할 수 있습니다."),
    NON_AVAILABLE_TOKEN(HttpStatus.BAD_REQUEST.value(), "6","토큰이 만료되었습니다.")
    ;

    private final int httpStatus;
    private final String code;
    private final String message;

}
