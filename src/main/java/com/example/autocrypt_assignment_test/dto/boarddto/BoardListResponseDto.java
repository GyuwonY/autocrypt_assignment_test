package com.example.autocrypt_assignment_test.dto.boarddto;

import com.example.autocrypt_assignment_test.model.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BoardListResponseDto {
    private List<Board> boardList;


}
