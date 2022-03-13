package com.stackoverflow.backend.controller;

import com.stackoverflow.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    @Operation(summary = "Save User",description = "Add user to the database")
    @ApiResponse(responseCode = "201",description = "Successfully created")
    public @ResponseBody
    ResponseEntity<Void> addUser() {
        userService.addUser();
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
