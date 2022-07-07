package com.example.autocrypt_assignment_test.service;

import com.example.autocrypt_assignment_test.dto.boarddto.BoardListRequestDto;
import com.example.autocrypt_assignment_test.dto.boarddto.BoardListResponseDto;
import com.example.autocrypt_assignment_test.dto.boarddto.BoardRequestDto;
import com.example.autocrypt_assignment_test.dto.boarddto.BoardResponseDto;
import com.example.autocrypt_assignment_test.model.Board;
import com.example.autocrypt_assignment_test.repository.BoardRepository;
import com.example.autocrypt_assignment_test.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public ResponseEntity<BoardResponseDto> createBoard(UserDetailsImpl userDetails, BoardRequestDto boardRequestDto) {
        boardRepository.save(new Board(boardRequestDto, userDetails.getUser()));
        return new ResponseEntity<>(new BoardResponseDto("게시글 작성이 완료되었습니다.", boardRequestDto), HttpStatus.OK);
    }

    public ResponseEntity<BoardListResponseDto> boardList(BoardListRequestDto boardListRequestDto, UserDetailsImpl userDetails) {

        return new ResponseEntity<>(new BoardListResponseDto(boardRepository.findAll()), HttpStatus.OK);
    }
    
}
