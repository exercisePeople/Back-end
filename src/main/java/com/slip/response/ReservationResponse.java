package com.slip.response;

import com.slip.Entitiy.Reservation;
import com.slip.Entitiy.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationResponse {
    /*
     * 게시글을 조회하는 로직은 조회를 한 후 그 값이 어떠한 상황에서도 변경되면 안되기 때문에 상수(final)을 선언해야한다,
     *
     * */
    private final Long resId;

    private final Long facilityId;

    private final String resName;

    private final String resLocation;

    private User userIdx;

    //오버로딩
    public ReservationResponse(Reservation reservation){
        this.resId = reservation.getResId();
        this.facilityId = reservation.getFacilityId();
        this.resName = reservation.getResName();
        this.resLocation = reservation.getResLocation();
        this.userIdx = reservation.getUser();
    }

    @Builder
    public ReservationResponse(Long resId,Long facilityId ,String resName, String resLocation, User userIdx){
        this.resId = resId;
        this.facilityId = facilityId;
        this.resName = resName;
        this.resLocation = resLocation;
        this.userIdx = userIdx;
    }
}
