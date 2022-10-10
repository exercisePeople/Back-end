package com.slip.response;

import com.slip.Entitiy.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostListResponse {

    /*
     * 게시글을 조회하는 로직은 조회를 한 후 그 값이 어떠한 상황에서도 변경되면 안되기 때문에 상수(final)을 선언해야한다,
     *
     * */
    private final Long id;
    private final String title;

    private final String userPostId;

    private final int hits;

    //오버로딩
    public PostListResponse(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.userPostId =post.getPostUserId();
        this.hits = post.getHits();
    }

    @Builder
    public PostListResponse(Long id, String title, String userPostId, int hits){
        this.id = id;
        this.title =title.substring(0,Math.min(title.length(),10));  // 제목의 길이가 길면 최대 길이를 10자로 끊어준다 (필수는 아님)
        this.userPostId =userPostId;
        this.hits =hits;
    }
}
