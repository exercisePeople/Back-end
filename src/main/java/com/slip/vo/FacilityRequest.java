package com.slip.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacilityRequest {

    private String facilityName;

    private String facilityLocation;

    @Builder
    public FacilityRequest(String facilityName, String facilityLocation){
        this.facilityName =facilityName;
        this.facilityLocation =facilityLocation;
    }
}
