package com.slip.repository;

import com.slip.Entitiy.Facility;
import com.slip.response.ReviewResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility,Long> {

}
