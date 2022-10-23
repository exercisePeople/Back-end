package com.slip.response;

import com.slip.Entitiy.Bookmark;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkResponse {

    private Long id;

    private Long facility;

    private Long user;

    private String bookmarkName;


    //오버로딩
    public BookmarkResponse(Bookmark bookmark){
        this.id = bookmark.getId();
        this.facility = bookmark.getFacility().getId();
        this.user = bookmark.getUser().getIdx();
        this.bookmarkName = bookmark.getBookmarkName();
    }

    @Builder
    public BookmarkResponse(Long id, Long facility, Long user, String bookmarkName){
        this.id = id;
        this.user = user;
        this.facility = facility;
        this.bookmarkName = bookmarkName;
    }




}
