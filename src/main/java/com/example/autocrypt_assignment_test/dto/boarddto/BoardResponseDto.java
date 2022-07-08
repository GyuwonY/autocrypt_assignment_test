package com.example.autocrypt_assignment_test.dto.boarddto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardResponseDto {
    private String msg;
    private String title;
    private String content;
    private boolean isPrivate;

    public BoardResponseDto(String msg, BoardRequestDto boardRequestDto){
        this.msg = msg;
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getTitle();
        this.isPrivate = boardRequestDto.isPrivate();
    }

    public BoardResponseDto(String msg){
        this.msg = msg;
    }
}
