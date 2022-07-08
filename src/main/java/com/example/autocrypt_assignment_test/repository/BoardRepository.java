package com.example.autocrypt_assignment_test.repository;

import com.example.autocrypt_assignment_test.model.Board;
import com.example.autocrypt_assignment_test.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long>{

    List<Board> findAllByPrivateOrUser(boolean isPrivate, User user);

    Optional<Board> findByBoardIdAndUser(Long boardId, User user);

}
