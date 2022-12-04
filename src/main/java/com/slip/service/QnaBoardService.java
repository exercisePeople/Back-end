package com.slip.service;

import com.slip.Entitiy.QnaBoard;
import com.slip.repository.QnaBoardRepository;
import com.slip.response.QnaBoardResponse;
import com.slip.vo.QnaBoardRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class QnaBoardService {

    private final QnaBoardRepository qnaBoardRepository;

    public void insertQna(QnaBoardRequest qnaBoardRequest){
        QnaBoard qnaBoard = QnaBoard.builder()
                .qanWriter(qnaBoardRequest.getQnaWriter())
                .qnaContent(qnaBoardRequest.getQnaContent())
                .build();

        qnaBoardRepository.save(qnaBoard);
    }

    public QnaBoardResponse oneReadQna(Long qnaId){
        QnaBoard qnaBoard = qnaBoardRepository.findById(qnaId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시글 입니다."));

        return QnaBoardResponse.builder()
                .qnaId(qnaBoard.getQnaId())
                .qnaWriter(qnaBoard.getQanWriter())
                .qnaContent(qnaBoard.getQnaContent())
                .build();
    }

    public List<QnaBoardResponse> allReadQna(){
        return qnaBoardRepository.findAllByOrderByQnaIdDesc();
    }
}
