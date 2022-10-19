package com.slip.response;

import com.slip.Entitiy.Post;
import com.slip.Entitiy.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {

    /*
    * 게시글을 조회하는 로직은 조회를 한 후 그 값이 어떠한 상황에서도 변경되면 안되기 때문에 상수(final)을 선언해야한다,
    *
    * */
    private Long id;
    private String title;
    private String content;

    private String userId;

    private int hits;

    //오버로딩
    public PostResponse(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.hits = post.getHits();
        this.userId = post.getUserId().getNickname();
    }

    @Builder
    public PostResponse(Long id, String title, String content,String userId){
        this.id = id;
        this.title =title.substring(0,Math.min(title.length(),10));  // 제목의 길이가 길면 최대 길이를 10자로 끊어준다 (필수는 아님)
        this.content = content;
        this.userId = userId;
    }
}
