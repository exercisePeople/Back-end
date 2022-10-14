package com.slip.repository;

import com.slip.Entitiy.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //List<Comment> findAllByOrderByIdDesc();
}
