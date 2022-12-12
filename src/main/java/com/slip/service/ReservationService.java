package com.slip.service;

import com.slip.Entitiy.Reservation;
import com.slip.Entitiy.User;
import com.slip.repository.ReservationRepository;
import com.slip.repository.UserRepository;
import com.slip.response.ReservationResponse;
import com.slip.vo.ReservationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {


    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;


    //예약 작성
    public void create(Long id,ReservationRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 유저입니다."));

        request.setUser(user);

        Reservation reservation = Reservation.builder()
                .user(request.getUser())
                .resName(request.getResName())
                .resLocation(request.getResLocation())
                .facilityId(request.getFacilityId())
                .build();

        reservationRepository.save(reservation);
    }

    //예얒 조회 기능
    public ReservationResponse get(Long id){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        return ReservationResponse.builder()
                .resId(reservation.getResId())
                .facilityId(reservation.getFacilityId())
                .resName(reservation.getResName())
                .resLocation(reservation.getResLocation())
                .build();
    }
}
