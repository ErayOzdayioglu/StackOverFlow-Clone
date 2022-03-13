package com.stackoverflow.backend.data.dto;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class CommentDto implements Serializable {
    private String text;

    private Integer voteCount;
}
