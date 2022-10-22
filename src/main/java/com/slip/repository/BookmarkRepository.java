package com.slip.repository;

import com.slip.Entitiy.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
}
