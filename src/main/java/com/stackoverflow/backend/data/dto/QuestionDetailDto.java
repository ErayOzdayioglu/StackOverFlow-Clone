package com.stackoverflow.backend.data.dto;

import com.stackoverflow.backend.data.entity.Answer;
import com.stackoverflow.backend.data.entity.Comment;
import com.stackoverflow.backend.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDetailDto {

    private String title;
    private String description;
    private String tag;
    private Date askedDate;
    private User askedBy;
    private Integer answerCount;
    private Integer voteCount;
    private List<AnswerDto> answers;
    private List<CommentDto> comments;
}
