package com.slip.controller;

import com.slip.response.FacilityResponse;
import com.slip.service.FacilityService;
import com.slip.service.ReviewService;
import com.slip.vo.FacilityRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;
    private final ReviewService reviewService;

    // 시설정보 추가
    @PostMapping("/facility/create")
    public void facCreate(@RequestBody @Valid FacilityRequest facilityRequest){
        facilityService.createFacility(facilityRequest);
    }

    // 시설정보 조회
    @GetMapping("/facility{facId}")
    public FacilityResponse getFacility(@PathVariable Long facId){
        return facilityService.getOne(facId);
    }
}
