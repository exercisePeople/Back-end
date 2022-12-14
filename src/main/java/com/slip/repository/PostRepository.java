package com.slip.repository;

import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import com.slip.response.PostListResponse;
import com.slip.response.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {


    List<PostListResponse> findAllByOrderByIdDesc();

    List<PostResponse> findByUserIdxOrderByIdDesc(User userIdx);

    List<PostListResponse> findByCategoryOrderByIdDesc(String category);

    List<PostListResponse> findByNoticeOrderByIdDesc(Long notice);

    @Transactional
    @Modifying
    @Query(value = "update post set hits = hits + 1 where id = :id",nativeQuery = true)
    int updateHits(@Param(value = "id") Long id);
}
