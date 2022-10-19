package com.slip.vo;

import com.slip.Entitiy.Comment;
import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import com.slip.response.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    private Long id;
    private String comment;
    private String writer;

    private Post posts;

    @Builder
    public CommentRequest(Post posts,String comment,String writer){
        this.posts = posts;
        this.comment = comment;
        this.writer = writer;
    }
}
