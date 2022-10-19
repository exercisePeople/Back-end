package com.slip.repository;

import com.slip.Entitiy.Comment;
import com.slip.Entitiy.Post;
import com.slip.response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<CommentResponse> findCommentByPostsOrderByIdDesc(Post post);
}
