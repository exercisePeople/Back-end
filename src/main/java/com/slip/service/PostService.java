package com.slip.service;

import com.slip.Entitiy.Post;
import com.slip.editor.PostEditor;
import com.slip.exception.PostNotFound;
import com.slip.repository.PostRepository;
import com.slip.response.PostResponse;
import com.slip.vo.PostCreate;
import com.slip.vo.PostEdit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //게시글 작성
    public void write(PostCreate postCreate) {
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .postUserId(postCreate.getPostUserId())
                .build();
        postRepository.save(post);
        System.out.println("게시글 작성 완료");
    }


    //게시글 단건 조회
    public PostResponse get(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }


    //게시글 전체 조회
    @Transactional
    public List<PostResponse> getAllPosts() {
        return postRepository.findAllByOrderByIdDesc().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }


    //게시글 수정
    @Transactional
    public void update(Long id, PostEdit postEdit) {
        Post post = postRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        PostEditor.PostEditorBuilder postEditorBuilder = post.toEditor();

        PostEditor postEditor = postEditorBuilder
                .title(postEdit.getTitle())
                .content(postEdit.getContent())
                .build();

        post.update(postEditor);
        System.out.println("게시글 수정 완료");
    }


    //게시글 삭제
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        postRepository.delete(post);
        System.out.println("게시글 삭제 완료");
    }

    //게시글 유저 조회
    public List<PostResponse> getUser(String postUserId){
        return postRepository.findPostByPostUserIdOrderByPostUserIdDesc(postUserId).stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }
}
