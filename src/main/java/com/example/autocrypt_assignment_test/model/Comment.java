package com.example.autocrypt_assignment_test.model;

import com.example.autocrypt_assignment_test.utils.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_comment")
public class Comment extends Timestamped {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column
    private Long commentId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long group;

    @Column(nullable = false)
    private int groupOrder;

    @Column(nullable = false)
    private int depth;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
