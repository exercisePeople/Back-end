package com.slip.response;


import com.slip.Entitiy.Review;
import lombok.Builder;

public class ReviewResponse {

    private Long id;

    private int grade;

    private String reviewTitle;

    private String reviewContent;

    public ReviewResponse(Review review){
        this.id = review.getId();
        this.grade = review.getGrade();
        this.reviewTitle = review.getReviewTitle();
        this.reviewContent = review.getReviewContent();
    }

    @Builder
    public ReviewResponse(Long id, int grade, String reviewTitle, String reviewContent){
        this.id = id;
        this.grade = grade;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
    }
}
