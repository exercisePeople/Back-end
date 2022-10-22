package com.slip.repository;

import com.slip.Entitiy.Facility;
import com.slip.Entitiy.Review;
import com.slip.response.ReviewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<ReviewResponse> findReviewByFacilityOrderByIdDesc(Facility facility);

    @Transactional
    @Modifying
    @Query(value = "select avg(grade) from review where facility = :id" ,nativeQuery = true)
    float plusGrade(@Param(value = "id") Long id);

    @Transactional
    @Modifying
    @Query(value = "select count(grade) from review" ,nativeQuery = true)
    float countReview();
}
