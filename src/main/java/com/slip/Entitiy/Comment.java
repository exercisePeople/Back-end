package com.slip.Entitiy;

import com.mysql.cj.protocol.ColumnDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "comments")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @Column(nullable = false, name = "writer")
    private String writer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user; // 작성자


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post posts;


    @Builder
    public Comment(String comment, String writer){
        this.comment = comment;
        this.writer = writer;
    }
}
