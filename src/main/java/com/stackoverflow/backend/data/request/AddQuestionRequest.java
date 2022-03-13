package com.stackoverflow.backend.data.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AddQuestionRequest {

    private String title;
    private String text;
    private String tag;
    private Integer userId;
}
