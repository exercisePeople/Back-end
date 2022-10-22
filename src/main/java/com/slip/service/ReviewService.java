package com.slip.service;

import com.slip.Entitiy.Facility;
import com.slip.Entitiy.Review;
import com.slip.repository.FacilityRepository;
import com.slip.repository.ReviewRepository;
import com.slip.response.ReviewResponse;
import com.slip.vo.ReviewRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final FacilityRepository facilityRepository;


    //후기 작성
    public void createReviews(Long id, ReviewRequest reviewRequest){
        Facility facility = facilityRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 시설입니다."));

        reviewRequest.setFacility(facility);

        Review review = Review.builder()
                .grade(reviewRequest.getGrade())
                .reviewTitle(reviewRequest.getReviewTitle())
                .reviewContent(reviewRequest.getReviewContent())
                .facility(reviewRequest.getFacility())
                .build();

        reviewRepository.save(review);
    }

    // 후기 단건 조회
    public List<ReviewResponse> readReviews(Long id){
        Facility facility = facilityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 시설입니다."));

        return reviewRepository.findReviewByFacilityOrderByIdDesc(facility);
    }


}
