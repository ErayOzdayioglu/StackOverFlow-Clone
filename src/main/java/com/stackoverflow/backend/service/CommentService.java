package com.stackoverflow.backend.service;

import com.stackoverflow.backend.data.dto.CommentDto;
import com.stackoverflow.backend.data.entity.Answer;
import com.stackoverflow.backend.data.entity.Comment;
import com.stackoverflow.backend.data.entity.Question;
import com.stackoverflow.backend.data.repository.AnswerRepository;
import com.stackoverflow.backend.data.repository.CommentRepository;
import com.stackoverflow.backend.data.repository.QuestionRepository;
import com.stackoverflow.backend.data.repository.UserRepository;
import com.stackoverflow.backend.data.request.AddRequest;
import com.stackoverflow.backend.data.request.UpdateRequest;
import com.stackoverflow.backend.data.response.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AnswerRepository answerRepository;


    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;


    public CommentResponse addCommentToQuestion(AddRequest addRequest) {
        Question question = questionRepository.findById(addRequest.getQuestionId()).get();
        Comment comment = new Comment();
        comment.setVoteCount(0);
        comment.setQuestion(question);
        comment.setText(addRequest.getText());
        comment.setUser(userRepository.findById(addRequest.getUserId()).get());
        question.getComments().add(comment);
        Integer commentId = commentRepository.save(comment).getId();
        questionRepository.save(question);

        CommentResponse commentDto = new CommentResponse();
        commentDto.setCommentId(commentId);
        commentDto.setQuestionId(question.getId());
        return commentDto;

    }

    public CommentResponse addCommentToAnswer(AddRequest addRequest) {
        Answer answer = answerRepository.findById(addRequest.getAnswerId()).get();
        Comment comment = new Comment();
        comment.setVoteCount(0);
        comment.setAnswer(answer);
        comment.setText(addRequest.getText());
        comment.setUser(userRepository.findById(addRequest.getUserId()).get());
        answer.getComments().add(comment);
        Integer commentId = commentRepository.save(comment).getId();
        answerRepository.save(answer);

        CommentResponse commentDto = new CommentResponse();
        commentDto.setCommentId(commentId);
        commentDto.setAnswerId(answer.getId());
        return commentDto;
    }

    public Integer voteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        comment.setVoteCount(comment.getVoteCount()+1);
        commentRepository.save(comment);
        return comment.getVoteCount();
    }

    public void deleteComment(Integer id) {
        Comment comment = commentRepository.findById(id).get();
        commentRepository.delete(comment);
    }

    public void updateComment(UpdateRequest updateRequest) {
        Comment comment = commentRepository.findById(updateRequest.getId()).get();
        comment.setText(updateRequest.getText());
        commentRepository.save(comment);
    }
}

