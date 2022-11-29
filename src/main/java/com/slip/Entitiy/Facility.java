//package com.slip.Entitiy;
//
//import lombok.*;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Getter
//@Table(name = "facility")
//@Entity
//public class Facility {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "facility_name")
//    private String facilityName;
//
//    @Column(name = "facility_location")
//    private String facilityLocation;
//
//    @Column(name = "grade_avg")
//    private float gradeAvg;
//
//    @Column(name = "facility_tel")
//    private Integer facilityTel;
//
//    @OneToMany(mappedBy = "facility", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @OrderBy("id asc") // 한개의 시설에 여러개의 리뷰
//    private List<Review> reviews;
//
//    @OneToOne(mappedBy = "facility", fetch = FetchType.LAZY)
//    private Bookmark bookmark;
//
//    @OneToOne(mappedBy = "facility", fetch = FetchType.LAZY)
//    private Reservation reservation;
//
//
//    @Builder
//    public Facility(String facilityName,String facilityLocation, float gradeAvg, Integer facilityTel){
//        this.gradeAvg = gradeAvg;
//        this.facilityName = facilityName;
//        this.facilityLocation = facilityLocation;
//        this.facilityTel = facilityTel;
//    }
//}
