package com.slip.repository;

import com.slip.Entitiy.Bookmark;
import com.slip.Entitiy.Facility;
import com.slip.response.ReviewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface FacilityRepository extends JpaRepository<Facility,Long> {


    @Transactional
    @Query(value = "select facility_name from facility where id = :id",nativeQuery = true)
    String selectFacilityName(Long id);

}
