package com.stackoverflow.backend.data.request;

import lombok.Data;

@Data
public class AddRequest {

    private Integer questionId;
    private Integer answerId;
    private String text;
    private Integer userId;
}
