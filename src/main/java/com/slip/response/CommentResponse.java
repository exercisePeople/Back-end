package com.slip.response;

import com.slip.Entitiy.Comment;
import com.slip.Entitiy.User;
import lombok.Builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentResponse {
    private Long id;
    private String comment;

    private String nickname;
    private Long postId;

    @Builder
    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.nickname = comment.getUser().getNickname();
        this.postId = comment.getPosts().getId();
    }

}
