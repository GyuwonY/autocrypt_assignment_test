package com.example.autocrypt_assignment_test.repository;

import com.example.autocrypt_assignment_test.model.Comment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long>{

    @Override
    @EntityGraph(attributePaths = {"board"})
    List<Comment> findAll();
}
