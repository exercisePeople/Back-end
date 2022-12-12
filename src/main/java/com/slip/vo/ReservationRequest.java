package com.slip.vo;


import com.slip.Entitiy.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Getter
@Setter
public class ReservationRequest {

    private Long facilityId;

    private User user;

    private String resName;

    private String resLocation;

    @Builder
    public ReservationRequest(User user, Long facilityId,String resName, String resLocation){
        this.user =user;
        this.facilityId = facilityId;
        this.resName = resName;
        this.resLocation = resLocation;
    }
}
