package com.slip.vo;


import com.slip.Entitiy.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReservationRequest {

    private Long facilityId;

    private User user;

    private String resName;

    private String resLocation;
}
