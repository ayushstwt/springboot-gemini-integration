package com.ayshriv.springai.controller;

import com.ayshriv.springai.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/qna")
public class AIController {

    @Autowired
    QnaService qnaService;

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String,String> payload) {
        String question = payload.get("question");
        String answer = qnaService.getAnswer(question);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}
