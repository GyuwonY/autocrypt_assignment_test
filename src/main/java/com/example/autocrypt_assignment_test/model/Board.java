package com.example.autocrypt_assignment_test.model;

import com.example.autocrypt_assignment_test.dto.boarddto.BoardRequestDto;
import com.example.autocrypt_assignment_test.utils.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_board")
public class Board extends Timestamped {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column
    private Long boardId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany
    @JoinColumn(name = "commentId")
    private List<Comment> comments;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean isPrivate;

    public Board(BoardRequestDto boardRequestDto, User user){
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.isPrivate = boardRequestDto.isPrivate();
        this.user = user;
    }

    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.isPrivate = boardRequestDto.isPrivate();
    }
}
