package com.slip.service;

import com.slip.Entitiy.Comment;
import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import com.slip.repository.CommentRepository;
import com.slip.repository.PostRepository;
import com.slip.repository.UserRepository;
import com.slip.response.CommentResponse;
import com.slip.response.PostListResponse;
import com.slip.vo.CommentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    //댓글 작성하기
    @Transactional
    public void writeComment(Long id,CommentRequest commentRequest) {

        Post post = postRepository.findById(id)
                        .orElseThrow(()->
                                new IllegalArgumentException("댓글 쓰기 실패 : 해당 게시글 존재 x"));

        commentRequest.setPosts(post);

        Comment comment = Comment.builder()
                .posts(commentRequest.getPosts())
                .comment(commentRequest.getComment())
                .writer(commentRequest.getWriter())
                .build();
        commentRepository.save(comment);
        System.out.println("댓글 작성 완료");
    }

    //댓글 조회하기
    @Transactional
    public List<CommentResponse> findComment(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("댓글 쓰기 실패 : 해당 게시글 존재 x"));

        return commentRepository.findCommentByPostsOrderByIdDesc(post);
    }
}
