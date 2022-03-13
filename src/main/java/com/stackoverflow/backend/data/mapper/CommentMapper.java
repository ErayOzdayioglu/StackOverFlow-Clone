package com.stackoverflow.backend.data.mapper;

import com.stackoverflow.backend.data.dto.CommentDto;
import com.stackoverflow.backend.data.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto commentToCommentDto(Comment comment);
}
