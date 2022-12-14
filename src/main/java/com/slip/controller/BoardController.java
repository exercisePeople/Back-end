package com.slip.controller;

import com.slip.Entitiy.User;
import com.slip.repository.PostRepository;
import com.slip.response.CommentResponse;
import com.slip.response.PostListResponse;
import com.slip.response.PostResponse;
import com.slip.service.CommentService;
import com.slip.service.PostService;
import com.slip.vo.CommentRequest;
import com.slip.vo.PostCreate;
import com.slip.vo.PostEdit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {


    private final PostService postService;
    private final CommentService commentService;

    //todo: 데이터베이스 H2로 변경하고 gradle multi Module 생성해보기
    //게시글 생성
    @PostMapping("/posts/{id}/create")
    public void post(@PathVariable Long id, @RequestBody @Valid PostCreate postCreate) {
        postService.write(id, postCreate);
    }


    //게시글 단건조회
    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable Long postId) {
        postService.updateHits(postId);
        return postService.get(postId);
    }


    //게시글 전체 조회
    @GetMapping("/posts")
    public List<PostListResponse> getAllPosts() {
        return postService.getAllPosts();
    }


    //게시글 수정
    @PatchMapping("/posts/update/{postId:[\\d]+}")
    public void update(@PathVariable Long postId, @RequestBody @Valid PostEdit request) {
        postService.update(postId, request);
    }


    //게시글 삭제
    @DeleteMapping("/posts/delete/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.delete(postId);
    }


    // 유저 게시블 조회(내가쓴글 조회)
    @GetMapping("/posts/user/{userIdx}")
    public List<PostResponse> getUser(@PathVariable User userIdx) {
        return postService.getUser(userIdx);
    }


    //카테고리 별 게시판 조회
    @GetMapping("/posts/category/{category}")
    public List<PostListResponse> getCategory(@PathVariable String category) {
        return postService.getCategory(category);
    }


    //게시글 댓글
    @PostMapping("/posts/{id}/{userId}/comment/write")
    public void commentSave(@PathVariable Long id, @PathVariable Long userId, @RequestBody CommentRequest commentRequest) {
        commentService.writeComment(id, userId, commentRequest);
    }

    //게시글 댓글 조회하기
    @GetMapping("/posts/{id}/comment")
    public List<CommentResponse> getAllComment(@PathVariable Long id) {
        return commentService.findComment(id);
    }

    //게시판 공지글 조회
    @GetMapping("/posts/notice/{noticeNum}")
    public List<PostListResponse> getNotice(@PathVariable Long noticeNum) {
        return postService.getNotice(noticeNum);
    }
}
