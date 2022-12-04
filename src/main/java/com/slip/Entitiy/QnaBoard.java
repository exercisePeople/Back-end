package com.slip.Entitiy;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "qna_board")
public class QnaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id")
    private Long qnaId;

    private String qanWriter;

    private String qnaContent;

    @Builder
    public QnaBoard(Long qnaId, String qanWriter, String qnaContent){
        this.qnaId = qnaId;
        this.qanWriter =qanWriter;
        this.qnaContent =qnaContent;
    }
}
