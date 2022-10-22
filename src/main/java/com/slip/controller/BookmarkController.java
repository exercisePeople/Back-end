package com.slip.controller;

import com.slip.service.BookmarkService;
import com.slip.vo.BookmarkRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/bookmark/{userId}/{facId}")
    public void bookmarkCreate(@PathVariable Long userId,@PathVariable Long facId, @RequestBody @Valid BookmarkRequest bookmarkRequest){
        bookmarkService.bookmarkPost(userId,facId,bookmarkRequest);
    }
}
