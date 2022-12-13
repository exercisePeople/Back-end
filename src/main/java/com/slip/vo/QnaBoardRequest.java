package com.slip.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class QnaBoardRequest {

    private String qnaWriter;

    private String qnaContent;
}
