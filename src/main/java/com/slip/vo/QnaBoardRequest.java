package com.slip.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class QnaBoardRequest {

    private String qnaWriter;

    private String qnaContent;

    @Builder
    public QnaBoardRequest(String qnaWriter, String qnaContent){
        this.qnaWriter = qnaWriter;
        this.qnaContent = qnaContent;
    }
}
