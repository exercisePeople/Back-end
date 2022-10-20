package com.slip.vo;

import com.slip.Entitiy.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationRequest {

    private int peoples; //인원수

    @Min(value = 2022,message = "연도가 2022년보다 작습니다")
    private int year; // 예약 연도

    @Min(value = 1, message = "1월보다 작습니다")
    @Max(value = 12, message = "12월보다 큽니다")
    private int month; // 예약 달
    private int resTime; // 예약 시간

    private User user;

    @Builder
    public ReservationRequest(User user,int peoples,int year,int month, int resTime){
        this.user =user;
        this.peoples = peoples;
        this.year =year;
        this.month=month;
        this.resTime = resTime;
    }
}
