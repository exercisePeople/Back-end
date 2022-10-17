package com.slip.repository;

import com.slip.Entitiy.Post;
import com.slip.response.PostListResponse;
import com.slip.response.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {


    List<PostListResponse> findAllByOrderByIdDesc();

    List<PostResponse> findByPostNicknameOrderByIdDesc(String postNickname);

    @Modifying
    @Query("update Post p set p.hits = p.hits + 1 where p.id = :id")
    int updateHits(Long id);
}
