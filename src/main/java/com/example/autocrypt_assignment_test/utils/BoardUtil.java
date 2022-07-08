package com.example.autocrypt_assignment_test.utils;

import com.example.autocrypt_assignment_test.dto.boarddto.BoardListRequestDto;
import com.example.autocrypt_assignment_test.model.Board;
import com.example.autocrypt_assignment_test.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BoardUtil {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardUtil(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

}
