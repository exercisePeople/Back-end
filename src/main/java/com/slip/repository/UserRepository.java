package com.slip.repository;

import com.slip.Entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);

    User findByNickname(String Nickname);


}
