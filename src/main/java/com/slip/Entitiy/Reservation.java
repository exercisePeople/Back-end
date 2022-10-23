package com.slip.Entitiy;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Table(name = "Reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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

    @Column(name = "res_name")
    private String resName;

    @Column(name = "res_location")
    private String resLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "facility_id")
    private Facility facility;



    @Builder
    public Reservation(User user,int peoples,  int year, int month, int resTime, Facility facility, String resName, String resLocation) {
        this.user = user;
        this.peoples = peoples;
        this.year =year;
        this.month = month;
        this.resTime = resTime;
        this.facility = facility;
        this.resName =resName;
        this.resLocation = resLocation;
    }

    @PrePersist // 데이터 생성이 이루어질때 사전 작업
    public void prePersist() {
        this.createAt = LocalDateTime.now();
    }
}
