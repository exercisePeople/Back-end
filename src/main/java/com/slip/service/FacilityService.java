package com.slip.service;

import com.slip.Entitiy.Facility;
import com.slip.Entitiy.Review;
import com.slip.repository.FacilityRepository;
import com.slip.repository.ReviewRepository;
import com.slip.response.FacilityResponse;
import com.slip.vo.FacilityRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;

    // 시설 정보 추가
    public void createFacility(FacilityRequest facilityRequest) {
        Facility facility = Facility.builder()
                .facilityName(facilityRequest.getFacilityName())
                .facilityLocation(facilityRequest.getFacilityLocation())
                .facilityTel(facilityRequest.getFacilityTel())
                .build();

        facilityRepository.save(facility);
    }

    //시설정보 조회
    public FacilityResponse getOne(Long id){
        Facility facility = facilityRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        return FacilityResponse.builder()
                .id(facility.getId())
                .facilityName(facility.getFacilityName())
                .facilityLocation(facility.getFacilityLocation())
                .gradeAvg(facility.getGradeAvg())
                .facilityTel(facility.getFacilityTel())
                .build();
    }


}
