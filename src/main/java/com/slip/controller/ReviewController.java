//package com.slip.controller;
//
//import com.slip.response.ReviewResponse;
//import com.slip.service.ReviewService;
//import com.slip.vo.ReviewRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//public class ReviewController {
//
//    private final ReviewService reviewService;
//
//    //후기 작성
//    @PostMapping("/review/{facId}")
//    public void createReview(@PathVariable Long facId,@RequestBody @Valid ReviewRequest request){
//        reviewService.createReviews(facId,request);
//    }
//
//    // 후기 조회
//    @GetMapping("/review/read/{facId}")
//    public List<ReviewResponse> readReview(@PathVariable Long facId){
//        return reviewService.readReviews(facId);
//    }
//
//}
//
