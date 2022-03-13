package com.stackoverflow.backend.data.dto;

import com.stackoverflow.backend.data.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AnswerDto {
    private String text;
    private Integer voteCount;
    private List<CommentDto> comments;
}
