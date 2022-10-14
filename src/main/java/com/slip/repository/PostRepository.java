package com.slip.repository;

import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    //오류 났음 고쳐야함
    List<Post> findPostByIdAndTitleAndPostNicknameAndHitsOrderByIdDesc();

    //List<Post> findPostByUser_NicknameOrderByIdIdDesc(Long id);
}
