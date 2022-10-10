package com.slip.controller;

import com.slip.response.PostResponse;
import com.slip.service.PostService;
import com.slip.vo.PostCreate;
import com.slip.vo.PostEdit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/")
    public String home(){
        return "AWS 연결 성공";
    }

    private final PostService postService;

    //게시글 생성
    @PostMapping("/posts/create")
    public void post(@RequestBody @Valid PostCreate postCreate){
        postService.write(postCreate);
    }

    //게시글 단건조회
    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable Long postId){
        return postService.get(postId);
    }


    //게시글 전체 조회
    @GetMapping("/posts")
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }


    //게시글 수정
    @PatchMapping("/posts/update/{postId}")
    public void update(@PathVariable Long postId, @RequestBody @Valid PostEdit request){
        postService.update(postId, request);
    }

    //게시글 삭제
    @DeleteMapping("/posts/delete/{postId}")
    public void delete(@PathVariable Long postId){
        postService.delete(postId);
    }


    @GetMapping("/posts/postUserId={postUserId}")
    public List<PostResponse> getUser(@PathVariable String postUserId){
        return postService.getUser(postUserId);
    }



}
