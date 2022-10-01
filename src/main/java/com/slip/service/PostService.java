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

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate postCreate) {
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();
        postRepository.save(post);
    }

    public PostResponse get(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    /* 페이징 처리는 나중에 처리
    * public List<PostResponse> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable).stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }
    * */

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
    }


    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        postRepository.delete(post);
    }
}
