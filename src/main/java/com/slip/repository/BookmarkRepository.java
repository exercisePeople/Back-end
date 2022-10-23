package com.slip.repository;

import com.slip.Entitiy.Bookmark;
import com.slip.Entitiy.User;
import com.slip.response.BookmarkResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {

    List<BookmarkResponse> findBookmarkByUserOrderByIdDesc(User user);
}
