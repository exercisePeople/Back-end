package com.slip.vo;

import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import lombok.*;
import org.springframework.security.core.parameters.P;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
public class PostCreate {


    private String title;
    private String content;
    private User userIdx;
    private String category;

    private String writer;

    private Long notice;


    @Builder
    public PostCreate(User userIdx,String title, String content,String category,String writer,Long notice){
        this.userIdx = userIdx;
        this.title = title;
        this.content = content;
        this.category = category;
        this.writer = writer;
        this.notice = notice;
    }


}
