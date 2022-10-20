package com.slip.vo;

import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import lombok.*;
import org.springframework.security.core.parameters.P;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class PostCreate {


    private String title;
    private String content;
    private String userId;

    private String category;


    @Builder
    public PostCreate(String userId,String title, String content,String category){
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.category = category;
    }


}
