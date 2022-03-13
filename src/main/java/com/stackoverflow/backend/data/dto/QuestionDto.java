package com.stackoverflow.backend.data.dto;

import com.stackoverflow.backend.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDto {

    private String title;
    private String description;
    private String tag;
    private Date askedDate;
    private User askedBy;
    private Integer answerCount;
    private Integer voteCount;
}
