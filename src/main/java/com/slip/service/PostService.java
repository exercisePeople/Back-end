package com.slip.service;

import com.slip.Entitiy.Comment;
import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import com.slip.editor.PostEditor;
import com.slip.exception.PostNotFound;
import com.slip.repository.CommentRepository;
import com.slip.repository.PostRepository;
import com.slip.repository.UserRepository;
import com.slip.response.PostListResponse;
import com.slip.response.PostResponse;
import com.slip.vo.CommentRequest;
import com.slip.vo.PostCreate;
import com.slip.vo.PostEdit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    //게시글 작성
    @Transactional
    public void write(Long id,PostCreate postCreate) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("가입되지 않은 계정입니다"));


        postCreate.setUserIdx(user);


        Post post = Post.builder()
                .userIdx(postCreate.getUserIdx())
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .category(postCreate.getCategory())
                .writer(postCreate.getWriter())
                .build();

       postRepository.save(post);
    }


    //게시글 단건 조회
    public PostResponse get(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .hits(post.getHits())
                .category(post.getCategory())
                .writer(post.getWriter())
                .build();
    }


    //게시글 전체 조회
    @Transactional
    public List<PostListResponse> getAllPosts() {
        return postRepository.findAllByOrderByIdDesc();
    }


    //게시글 내가 쓴글 조회
    public List<PostResponse> getUser(Long userIdx){
        return postRepository.findByUserIdxOrderByIdDesc(userIdx);
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

    //게시글 조회수 증가
    public void  updateHits(Long postId){
        int result = 0;
        result = postRepository.updateHits(postId);
    }

    //게시글 카테고리별 조회
    public List<PostListResponse> getCategory(String category) {
        return postRepository.findByCategoryOrderByIdDesc(category);
    }
}
