package com.slip.service;

import com.slip.Entitiy.Comment;
import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import com.slip.editor.PostEditor;
import com.slip.exception.PostNotFound;
import com.slip.repository.CommentRepository;
import com.slip.repository.PostRepository;
import com.slip.response.PostListResponse;
import com.slip.response.PostResponse;
import com.slip.vo.CommentRequest;
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

    private final CommentRepository commentRepository;

    //게시글 작성
    @Transactional
    public void write(PostCreate postCreate) {
        Post post = Post.builder()
                .postNickname(postCreate.getPostNickname())
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();
       postRepository.save(post);
    }


    //게시글 단건 조회
    public PostResponse get(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        int cnt = post.getHits();
        post.setHits(cnt + 1);

        return PostResponse.builder()
                .id(post.getId())
                .postNickname(post.getPostNickname())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }


    //게시글 전체 조회
    @Transactional
    public List<PostListResponse> getAllPosts() {
        return postRepository.findAllByOrderByIdDesc();
    }


    //게시글 유저 조회
    public List<PostResponse> getUser(String postNickname){
        return postRepository.findByPostNicknameOrderByIdDesc(postNickname);

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


    //댓글 작성하기
    @Transactional
    public void writeComment(CommentRequest commentRequest) {
        Comment comment = Comment.builder()
                .comment(commentRequest.getComment())
                .comment(commentRequest.getWriter())
                .build();
        commentRepository.save(comment);
        System.out.println("댓글 작성 완료");
    }

    //조회수 증가


}
