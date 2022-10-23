package com.slip.repository;

import com.slip.Entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);

    User findByNickname(String Nickname);


    @Transactional
    @Query(value = "select nickname from member where idx = :idx",nativeQuery = true)
    String selectUserNickname(Long idx);


}
