package com.stackoverflow.backend.controller;

import com.stackoverflow.backend.data.request.AddRequest;
import com.stackoverflow.backend.data.dto.AnswerDto;
import com.stackoverflow.backend.data.request.UpdateRequest;
import com.stackoverflow.backend.data.response.AnswerResponse;
import com.stackoverflow.backend.service.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    @Operation(summary = "create answer for question")
    @ApiResponse(responseCode = "201",description = "Successfully created")
    public ResponseEntity<AnswerResponse> addAnswer(@RequestBody AddRequest addAnswerRequest) {
        return new ResponseEntity<>(answerService.addAnswerToQuestion(addAnswerRequest), HttpStatus.CREATED);
    }

    @PutMapping("/vote/{id}")
    @Operation(summary = "vote the answer")
    @ApiResponse(responseCode = "200",description = "Successfully voted")
    public ResponseEntity<Integer> voteQuestion(@PathVariable Integer id) {
        return new ResponseEntity<>(answerService.voteAnswer(id),HttpStatus.OK);
    }

    @PutMapping()
    @Operation(summary = "update an answer")
    @ApiResponse(responseCode = "200",description = "Successfully updated")
    public ResponseEntity<Void> updateAnswer(@RequestBody UpdateRequest updateRequest) {
        answerService.updateAnswer(updateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
