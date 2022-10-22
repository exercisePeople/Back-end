package com.slip.response;

import com.slip.Entitiy.Facility;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacilityResponse {

    private Long id;

    private String facilityName;

    private String facilityLocation;

    private float gradeAvg;


    //오버 로딩
    public FacilityResponse(Facility facility){
        this.id = facility.getId();
        this.facilityName = facility.getFacilityName();
        this.facilityLocation = facility.getFacilityLocation();
        this.gradeAvg = facility.getGradeAvg();
    }

    @Builder
    public FacilityResponse(Long id, String facilityName, String facilityLocation, float gradeAvg){
        this.id =id;
        this.facilityName = facilityName;
        this.facilityLocation = facilityLocation;
        this.gradeAvg =gradeAvg;
    }
}
