package com.slip.controller;

import com.slip.response.QnaBoardResponse;
import com.slip.service.QnaBoardService;
import com.slip.vo.QnaBoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QnaBoardController {

    private final QnaBoardService qnaBoardService;

    @PostMapping("/qna/insert")
    public void insertQna(@RequestBody QnaBoardRequest qnaBoardRequest){
        qnaBoardService.insertQna(qnaBoardRequest);
    }

    @GetMapping("/qna/read")
    public List<QnaBoardResponse> allReadQna(){
        return qnaBoardService.allReadQna();
    }

    @GetMapping("/qna/readOne/{qnaId}")
    public QnaBoardResponse readQna(@PathVariable Long qnaId){
        return qnaBoardService.oneReadQna(qnaId);
    }
}
