package com.slip.response;

import com.slip.Entitiy.Reservation;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class ReservationResponse {
    /*
     * 게시글을 조회하는 로직은 조회를 한 후 그 값이 어떠한 상황에서도 변경되면 안되기 때문에 상수(final)을 선언해야한다,
     *
     * */
    private final Long resId;
    private final int peoples;
    private final int year;
    private final int month;
    private final int resTime;

    private final String resName;

    private final String resLocation;

    //오버로딩
    public ReservationResponse(Reservation reservation){
        this.resId = reservation.getResId();
        this.peoples = reservation.getPeoples();
        this.year =reservation.getYear();
        this.month = reservation.getMonth();
        this.resTime = reservation.getResTime();
        this.resName = reservation.getFacility().getFacilityName();
        this.resLocation = reservation.getFacility().getFacilityLocation();
    }

    @Builder
    public ReservationResponse(Long resId, int peoples, int year,int month, int resTime, String resName, String resLocation){
        this.resId = resId;
        this.peoples = peoples;
        this.year = year;
        this.month = month;
        this.resTime = resTime;
        this.resName = resName;
        this.resLocation = resLocation;
    }
}
