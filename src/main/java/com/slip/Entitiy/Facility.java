package com.slip.Entitiy;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "facility")
@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tmp;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookmark_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bookmark bookmarks;

    @OneToMany(mappedBy = "facility", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") // 댓글 정렬
    private List<Review> reviews;


    @Builder
    public Facility(String tmp){
        this.tmp = tmp;
    }
}
