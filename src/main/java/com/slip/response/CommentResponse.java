package com.slip.response;

import com.slip.Entitiy.Comment;
import com.slip.Entitiy.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponse {
    private Long id;
    private String writer;
    private String comment;


    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.writer = comment.getWriter();
    }

    @Builder
    public CommentResponse(Long id, String writer, String comment){
        this.id = id;
        this.comment =comment;
        this.writer = writer;
    }
}
