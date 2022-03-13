package com.stackoverflow.backend.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponse {
    private Integer commentId;
    private Integer questionId;
    private Integer answerId;
}
