package com.slip.controller;

import com.slip.response.BookmarkResponse;
import com.slip.service.BookmarkService;
import com.slip.vo.BookmarkRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    // 북마크 등록
    @PostMapping("/bookmark/{userId}/{facId}")
    public void bookmarkCreate(@PathVariable Long userId,@PathVariable Long facId, @RequestBody @Valid BookmarkRequest bookmarkRequest){
        bookmarkService.bookmarkPost(userId,facId,bookmarkRequest);
    }

    // 북마크 조회
    @GetMapping("/bookmark/read/{userId}")
    public List<BookmarkResponse> getBookmark(@PathVariable Long userId){
        return bookmarkService.findBookmark(userId);
    }

}
