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
    private User userId;



    @Builder
    public PostCreate(User userId,String title, String content){
        this.userId = userId;
        this.title = title;
        this.content = content;
    }


}
