package com.slip.controller;

import com.slip.response.ReservationResponse;
import com.slip.service.ReservationService;
import com.slip.vo.ReservationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    //예약 설정
    @PostMapping("/reservation/{userId}/create")
    public void resCreate(@PathVariable String userId,@RequestBody @Valid ReservationRequest reservationRequest){
        reservationService.create(userId,reservationRequest);
    }

    //예약 조회
    @GetMapping("/reservation/{resId}")
    public ReservationResponse get(@PathVariable Long resId){
        return reservationService.get(resId);
    }
}
