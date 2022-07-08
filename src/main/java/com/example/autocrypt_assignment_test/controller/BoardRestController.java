package com.example.autocrypt_assignment_test.controller;

import com.example.autocrypt_assignment_test.dto.boarddto.BoardListRequestDto;
import com.example.autocrypt_assignment_test.dto.boarddto.BoardListResponseDto;
import com.example.autocrypt_assignment_test.dto.boarddto.BoardRequestDto;
import com.example.autocrypt_assignment_test.dto.boarddto.BoardResponseDto;
import com.example.autocrypt_assignment_test.security.UserDetailsImpl;
import com.example.autocrypt_assignment_test.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BoardRestController {
    private final BoardService boardService;

    @Autowired
    public BoardRestController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/board")
    public ResponseEntity<BoardResponseDto> createBoard(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(userDetails, boardRequestDto);
    }

    @GetMapping("/board")
    public ResponseEntity<BoardListResponseDto> boardList(@AuthenticationPrincipal UserDetailsImpl userDetails){

        return boardService.boardList(userDetails);
    }

    @PutMapping("/board")
    public ResponseEntity<BoardResponseDto> updateBoard(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody BoardRequestDto boardRequestDto){
        return boardService.updateBoard(userDetails, boardRequestDto);
    }

    @DeleteMapping("/board/{boardid}")
    public ResponseEntity<BoardResponseDto> deleteBoard(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long boardid){
        return boardService.deleteBoard(userDetails, boardid);
    }

}
