package com.stackoverflow.backend.controller;

import com.stackoverflow.backend.data.dto.QuestionDetailDto;
import com.stackoverflow.backend.data.dto.QuestionDto;
import com.stackoverflow.backend.data.mapper.QuestionMapper;
import com.stackoverflow.backend.data.request.AddQuestionRequest;
import com.stackoverflow.backend.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    @Operation(summary = "Get all questions")
    @ApiResponse(responseCode = "200",description = "Successfully fetched")
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping(value = "/tags")
    @Operation(summary = "Get all questions with specific tag")
    @ApiResponse(responseCode = "200",description = "Successfully fetched questions")
    public ResponseEntity<List<QuestionDto>> getAllQuestionsWithTag(@RequestParam("tag") String tag) {
        return new ResponseEntity<>(questionService.getAllByTags(tag),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get the question with id")
    @ApiResponse(responseCode = "200",description = "Successfully fetched")
    public ResponseEntity<QuestionDetailDto> getQuestionById(@PathVariable Integer id) {

        return new ResponseEntity<>(questionService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "create question")
    @ApiResponse(responseCode = "201",description = "Successfully created the question")
    public ResponseEntity<Integer> addQuestion(@RequestBody AddQuestionRequest addQuestionRequest) {
        return new ResponseEntity<>(questionService.addQuestion(addQuestionRequest),HttpStatus.CREATED);
    }

    @PutMapping("/vote/{questionid}")
    @Operation(summary = "vote the question with given id")
    @ApiResponse(responseCode = "200",description = "Successfully voted")
    public ResponseEntity<Integer> voteQuestion(@PathVariable Integer questionid) {
        return new ResponseEntity<>(questionService.voteQuestion(questionid),HttpStatus.OK);
    }



}
