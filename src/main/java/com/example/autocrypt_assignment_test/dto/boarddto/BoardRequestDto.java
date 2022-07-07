package com.example.autocrypt_assignment_test.dto.boarddto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {
    private String title;
    private String content;
    private boolean isPrivate;
}
