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
    public void create(Long id,Long facId,ReservationRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 유저입니다."));

        Facility facility = facilityRepository.findById(facId)
                .orElseThrow(()-> new IllegalArgumentException("등록되지 않은 시설입니다."));

        String facilityName = facilityRepository.selectFacilityName(facId);
        String facilityLocation = facilityRepository.selectFacilityLocation(facId);

        request.setResName(facilityName);
        request.setResLocation(facilityLocation);
        request.setUser(user);
        request.setFacility(facility);


        Reservation reservation = Reservation.builder()
                .peoples(request.getPeoples())
                .year(request.getYear())
                .month(request.getMonth())
                .resTime(request.getResTime())
                .user(request.getUser())
                .resName(request.getResName())
                .resLocation(request.getResLocation())
                .facility(request.getFacility())
                .build();

        reservationRepository.save(reservation);
        System.out.println("예약 테이블에 저장성공");
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
                .build();
    }
}
