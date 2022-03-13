package com.stackoverflow.backend.data.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UpdateRequest implements Serializable {

    private Integer id;
    private String text;
}
