package com.slip.controller;

import com.slip.response.PostResponse;
import com.slip.service.PostService;
import com.slip.vo.PostCreate;
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

    private final PostService postService;

    //게시글 생성
    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate postCreate){
        postService.write(postCreate);
    }

    //게시글 조회
    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable Long postId){
        return postService.get(postId);
    }

    //게시글 페이징 처리는 나중에 아직 이해하지 못함
    /*
    * @GetMapping("/posts")
    public List<PostResponse> getAllPosts(@PageableDefault(size = 5) Pageable pageable){
        return postService.getAllPosts(pageable);
    }
    * */



}
