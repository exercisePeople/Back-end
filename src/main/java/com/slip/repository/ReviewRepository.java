package com.slip.repository;

import com.slip.Entitiy.Facility;
import com.slip.Entitiy.Review;
import com.slip.response.ReviewResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<ReviewResponse> findReviewByFacilityOrderByIdDesc(Facility facility);
}
