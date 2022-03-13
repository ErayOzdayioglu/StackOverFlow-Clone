package com.stackoverflow.backend.data.mapper;

import com.stackoverflow.backend.data.dto.QuestionDetailDto;
import com.stackoverflow.backend.data.dto.QuestionDto;
import com.stackoverflow.backend.data.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionDto questionToQuestionDto(Question question);
    QuestionDetailDto questionToQuestionDetailDto(Question question);
}
