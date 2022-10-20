package com.slip.controller;

import com.slip.response.ReviewResponse;
import com.slip.service.ReviewService;
import com.slip.vo.ReviewRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/review/{facId}")
    public void createReview(@PathVariable Long facid,@RequestBody ReviewRequest request){
        reviewService.createReviews(facid,request);
    }

    @GetMapping("/review/read/{facId}/{revId}")
    public ReviewResponse readReview(@PathVariable Long revId, @PathVariable Long facId){
        return reviewService.readReviews(revId,facId);
    }
}
