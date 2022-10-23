package com.slip.service;

import com.slip.Entitiy.Bookmark;
import com.slip.Entitiy.Facility;
import com.slip.Entitiy.User;
import com.slip.repository.BookmarkRepository;
import com.slip.repository.FacilityRepository;
import com.slip.repository.UserRepository;
import com.slip.response.BookmarkResponse;
import com.slip.response.FacilityResponse;
import com.slip.vo.BookmarkRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final FacilityRepository facilityRepository;

    private final UserRepository  userRepository;

    private final BookmarkRepository bookmarkRepository;

    //북마크 저장하기
    // 유저 아이디와 시설정보의 유효성 검사 후 북마크 등록하기
    public void bookmarkPost(Long userId,Long facId, BookmarkRequest bookmarkRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("가입되지 않은 유저입니다."));

        Facility facility = facilityRepository.findById(facId)
                .orElseThrow(()-> new IllegalArgumentException("등록되지 않은 시설입니다."));

        String facilityName = facilityRepository.selectFacilityName(facId);

        bookmarkRequest.setUser(user);
        bookmarkRequest.setFacility(facility);
        bookmarkRequest.setBookmarkName(facilityName);

        Bookmark bookmark = Bookmark.builder()
                .user(bookmarkRequest.getUser())
                .facility(bookmarkRequest.getFacility())
                .bookmarkName(bookmarkRequest.getBookmarkName())
                .build();

        bookmarkRepository.save(bookmark);
    }

    // 북마크 조회하기
    @Transactional
    public List<BookmarkResponse> findBookmark(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("가입되지 않은 유저입니다"));

        return bookmarkRepository.findBookmarkByUserOrderByIdDesc(user);
    }

}
