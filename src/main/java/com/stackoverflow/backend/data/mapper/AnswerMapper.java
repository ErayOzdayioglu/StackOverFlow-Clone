package com.stackoverflow.backend.data.mapper;

import com.stackoverflow.backend.data.dto.AnswerDto;
import com.stackoverflow.backend.data.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerDto answerToAnswerDto(Answer answer);

}
