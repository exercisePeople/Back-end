package com.slip.repository;

import com.slip.Entitiy.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository  extends JpaRepository<Reservation,Long> {
}
