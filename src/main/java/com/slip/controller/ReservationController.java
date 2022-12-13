package com.slip.controller;

import com.slip.Entitiy.User;
import com.slip.response.ReservationResponse;
import com.slip.service.ReservationService;
import com.slip.vo.ReservationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    //예약 설정
    @PostMapping("/reservation/{userId}/create")
    public void resCreate(@PathVariable Long userId ,@RequestBody @Valid ReservationRequest reservationRequest){
        reservationService.create(userId,reservationRequest);
    }

    //예약 조회
    @GetMapping("/reservation/{facilityId}")
    public List<ReservationResponse> get(@PathVariable Long facilityId){
        return reservationService.get(facilityId);
    }

    //내가 예약한 글 조회
    @GetMapping("/reservation/user/{userId}")
    public List<ReservationResponse> getUser(@PathVariable User userId){
        return reservationService.getUser(userId);
    }
}
