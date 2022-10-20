package com.slip.Entitiy;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grade")
    private int grade;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "review_content")
    private String reviewContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Facility facility;



    @Builder
    public Review(Facility facility,int grade, String reviewTitle, String reviewContent){
        this.facility =facility;
        this.grade = grade;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
    }


}
