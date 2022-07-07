package com.example.autocrypt_assignment_test.dto.boarddto;

import com.example.autocrypt_assignment_test.dto.boarddto.boardenum.BoardListSortEnum;
import com.example.autocrypt_assignment_test.dto.boarddto.boardenum.BoardListTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListRequestDto {
    private BoardListTypeEnum type;
    private BoardListSortEnum sort;
}
