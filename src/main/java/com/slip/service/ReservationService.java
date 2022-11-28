package com.slip.service;

import com.slip.Entitiy.Facility;
import com.slip.Entitiy.Post;
import com.slip.Entitiy.Reservation;
import com.slip.Entitiy.User;
import com.slip.editor.PostEditor;
import com.slip.exception.PostNotFound;
import com.slip.repository.FacilityRepository;
import com.slip.repository.ReservationRepository;
import com.slip.repository.UserRepository;
import com.slip.response.PostResponse;
import com.slip.response.ReservationResponse;
import com.slip.vo.PostCreate;
import com.slip.vo.PostEdit;
import com.slip.vo.ReservationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {


    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;

    private final FacilityRepository facilityRepository;


    //예약 작성
    public void create(Long id,ReservationRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 유저입니다."));

        request.setUser(user);


        Reservation reservation = Reservation.builder()
                .peoples(request.getPeoples())
                .year(request.getYear())
                .month(request.getMonth())
                .resTime(request.getResTime())
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
                .peoples(reservation.getPeoples())
                .resId(reservation.getResId())
                .year(reservation.getYear())
                .month(reservation.getMonth())
                .resTime(reservation.getResTime())
                .resName(reservation.getResName())
                .resLocation(reservation.getResLocation())
                .build();
    }
}
