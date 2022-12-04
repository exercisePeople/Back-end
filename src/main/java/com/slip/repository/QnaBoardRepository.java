package com.slip.repository;

import com.slip.Entitiy.QnaBoard;
import com.slip.response.QnaBoardResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QnaBoardRepository extends JpaRepository<QnaBoard,Long> {

    List<QnaBoardResponse> findAllByOrderByQnaIdDesc();
}
