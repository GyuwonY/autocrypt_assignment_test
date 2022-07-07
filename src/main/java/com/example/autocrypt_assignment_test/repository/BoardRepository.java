package com.example.autocrypt_assignment_test.repository;

import com.example.autocrypt_assignment_test.model.Board;
import com.example.autocrypt_assignment_test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {

}
