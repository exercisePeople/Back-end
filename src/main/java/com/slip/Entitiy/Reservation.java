package com.slip.Entitiy;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Table(name = "Reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;

    @Column(name = "peoples")
    private int peoples;

    @Column(name = "year")
    private int year;

    @Column(name = "month")
    private int month;

    @Column(name = "resTime")
    private int resTime;

    @Column(name = "create_at")
    private LocalDateTime createAt;


    @Builder
    public Reservation(int peoples,  int year, int month, int resTime) {
        this.peoples = peoples;
        this.year =year;
        this.month = month;
        this.resTime = resTime;
    }

    @PrePersist // 데이터 생성이 이루어질때 사전 작업
    public void prePersist() {
        this.createAt = LocalDateTime.now();
    }
}
