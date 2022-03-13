package com.stackoverflow.backend.controller;

import com.stackoverflow.backend.data.dto.CommentDto;
import com.stackoverflow.backend.data.request.AddRequest;
import com.stackoverflow.backend.data.request.UpdateRequest;
import com.stackoverflow.backend.data.response.CommentResponse;
import com.stackoverflow.backend.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/question")
    @Operation(summary = "create comment for question")
    @ApiResponse(responseCode = "201",description = "Successfully created")
    public ResponseEntity<CommentResponse> addCommentToQuestion(@RequestBody AddRequest addRequest) {
        return new ResponseEntity<>(commentService.addCommentToQuestion(addRequest), HttpStatus.CREATED);
    }

    @PostMapping("/answer")
    @Operation(summary = "create comment for answer")
    @ApiResponse(responseCode = "201",description = "Successfully created")
    public ResponseEntity<CommentResponse> addCommentToAnswer(@RequestBody AddRequest addRequest) {
        return new ResponseEntity<>(commentService.addCommentToAnswer(addRequest),HttpStatus.CREATED);
    }

    @PutMapping("/vote/{id}")
    @Operation(summary = "vote comment with id")
    @ApiResponse(responseCode = "200",description = "Successfully voted")
    public ResponseEntity<Integer> voteComment(@PathVariable Integer id) {
        return new ResponseEntity<>(commentService.voteComment(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete comment")
    @ApiResponse(responseCode = "200",description = "Successfully deleted")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping()
    @Operation(summary = "update the comment")
    @ApiResponse(responseCode = "200",description = "Successfully updated")
    public ResponseEntity<Void> updateComment(@RequestBody UpdateRequest updateRequest) {
        commentService.updateComment(updateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
