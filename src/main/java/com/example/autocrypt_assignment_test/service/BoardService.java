package com.example.autocrypt_assignment_test.service;

import com.example.autocrypt_assignment_test.dto.boarddto.BoardListResponseDto;
import com.example.autocrypt_assignment_test.dto.boarddto.BoardRequestDto;
import com.example.autocrypt_assignment_test.dto.boarddto.BoardResponseDto;
import com.example.autocrypt_assignment_test.exception.CustomException;
import com.example.autocrypt_assignment_test.exception.ErrorCode;
import com.example.autocrypt_assignment_test.model.Board;
import com.example.autocrypt_assignment_test.repository.BoardRepository;
import com.example.autocrypt_assignment_test.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public ResponseEntity<BoardResponseDto> createBoard(UserDetailsImpl userDetails, BoardRequestDto boardRequestDto) {

        boardRepository.save(new Board(boardRequestDto, userDetails.getUser()));
        return new ResponseEntity<>(new BoardResponseDto("게시글 작성이 완료되었습니다.", boardRequestDto), HttpStatus.OK);
    }


    @Transactional
    public ResponseEntity<BoardListResponseDto> boardList(UserDetailsImpl userDetails) {

        List<Board> boardList = boardRepository.findAllByIsPrivateOrUser(false,userDetails.getUser());
        return new ResponseEntity<>(new BoardListResponseDto(boardList), HttpStatus.OK);
    }


    @Transactional
    public ResponseEntity<BoardResponseDto> updateBoard(UserDetailsImpl userDetails, BoardRequestDto boardRequestDto) {

        Board board = boardRepository.findByBoardIdAndUser(boardRequestDto.getBoardId(), userDetails.getUser())
                .orElseThrow(() -> new CustomException(ErrorCode.WRONG_BOARDID));

        board.update(boardRequestDto);

        return new ResponseEntity<>(new BoardResponseDto("게시글 수정이 완료되었습니다.", boardRequestDto), HttpStatus.OK);
    }


    public ResponseEntity<BoardResponseDto> deleteBoard(UserDetailsImpl userDetails, Long boardid) {

        Board board = boardRepository.findByBoardIdAndUser(boardid, userDetails.getUser())
                .orElseThrow(() -> new CustomException(ErrorCode.WRONG_BOARDID));

        boardRepository.delete(board);

        return new ResponseEntity<>(new BoardResponseDto("게시글 삭제가 완료되었습니다."), HttpStatus.OK);
    }
}
