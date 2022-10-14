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

    private String postNickname;
    private String title;
    private String content;


    @Builder
    public PostCreate(String postNickname,String title, String content){
        this.postNickname = postNickname;
        this.title = title;
        this.content = content;
    }


}
