package com.slip.response;

import com.slip.Entitiy.QnaBoard;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaBoardResponse {

    private Long qnaId;

    private String qnaWriter;

    private String qnaContent;


    public QnaBoardResponse(QnaBoard qnaBoard){
        this.qnaId = qnaBoard.getQnaId();
        this.qnaWriter = qnaBoard.getQanWriter();
        this.qnaContent = qnaBoard.getQnaContent();
    }

    @Builder
    public QnaBoardResponse(Long qnaId, String qnaWriter,String qnaContent){
        this.qnaId = qnaId;
        this.qnaWriter = qnaWriter;
        this.qnaContent = qnaContent;
    }
}
