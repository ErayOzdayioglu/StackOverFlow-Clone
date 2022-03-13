package com.stackoverflow.backend.service;

import com.stackoverflow.backend.data.entity.Answer;
import com.stackoverflow.backend.data.entity.Question;
import com.stackoverflow.backend.data.repository.AnswerRepository;
import com.stackoverflow.backend.data.repository.QuestionRepository;
import com.stackoverflow.backend.data.repository.UserRepository;
import com.stackoverflow.backend.data.request.AddRequest;
import com.stackoverflow.backend.data.dto.AnswerDto;
import com.stackoverflow.backend.data.request.UpdateRequest;
import com.stackoverflow.backend.data.response.AnswerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    public AnswerResponse addAnswerToQuestion(AddRequest addAnswerRequest) {
        Question question = questionRepository.findById(addAnswerRequest.getQuestionId())
                .orElseThrow(()-> new NullPointerException());
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setText(addAnswerRequest.getText());
        answer.setVoteCount(0);
        answer.setUser(userRepository.findById(addAnswerRequest.getUserId()).get());
        question.getAnswers().add(answer);
        question.setAnswerCount(question.getAnswerCount()+1);
        Integer answerId = answerRepository.save(answer).getId();
        questionRepository.save(question);

        AnswerResponse response = new AnswerResponse();
        response.setAnswerId(answerId);
        response.setQuestionId(question.getId());
        return response;
    }

    public Integer voteAnswer(Integer answerId) {
        Answer answer = answerRepository.findById(answerId).get();
        answer.setVoteCount(answer.getVoteCount()+1);
        answerRepository.save(answer);
        return answer.getVoteCount();
    }

    public void updateAnswer(UpdateRequest updateRequest) {
        Answer answer = answerRepository.findById(updateRequest.getId()).get();
        answer.setText(updateRequest.getText());
        answerRepository.save(answer);
    }
}
