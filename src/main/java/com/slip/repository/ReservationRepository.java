package com.slip.repository;

import com.slip.Entitiy.Reservation;
import com.slip.Entitiy.User;
import com.slip.response.ReservationResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository  extends JpaRepository<Reservation,Long> {

    List<ReservationResponse> findAllByFacilityId(Long facilityId);

    List<ReservationResponse> findByUserOrderByResIdDesc(User userId);
}
