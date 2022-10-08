package com.slip.service;

import com.slip.Entitiy.Post;
import com.slip.Entitiy.Reservation;
import com.slip.editor.PostEditor;
import com.slip.exception.PostNotFound;
import com.slip.repository.ReservationRepository;
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


    //예약 작성
    public void create(ReservationRequest request) {
        Reservation reservation = Reservation.builder()
                .peoples(request.getPeoples())
                .year(request.getYear())
                .month(request.getMonth())
                .resTime(request.getResTime())
                .build();
        reservationRepository.save(reservation);
        System.out.println("예약 테이블에 저장성공");
    }

    public ReservationResponse get(Long id){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        return ReservationResponse.builder()
                .resId(reservation.getResId())
                .year(reservation.getYear())
                .month(reservation.getMonth())
                .resTime(reservation.getResTime())
                .build();
    }









}
