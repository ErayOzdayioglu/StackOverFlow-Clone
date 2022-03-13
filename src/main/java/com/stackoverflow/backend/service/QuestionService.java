package com.stackoverflow.backend.service;

import com.stackoverflow.backend.data.dto.QuestionDetailDto;
import com.stackoverflow.backend.data.dto.QuestionDto;
import com.stackoverflow.backend.data.entity.Question;
import com.stackoverflow.backend.data.mapper.QuestionMapper;
import com.stackoverflow.backend.data.repository.QuestionRepository;
import com.stackoverflow.backend.data.repository.UserRepository;
import com.stackoverflow.backend.data.request.AddQuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionDto> questionDtos = new ArrayList<>();
        for (Question question : questions) {
            if (question.getDescription().length() > 100) question.setDescription(question.getDescription().substring(0,100));
            questionDtos.add(questionMapper.questionToQuestionDto(question));
        }
        return questionDtos;
    }

    public Integer addQuestion(AddQuestionRequest addQuestionRequest) {
        Question question = new Question();
        question.setTitle(addQuestionRequest.getTitle());
        question.setDescription(addQuestionRequest.getText());
        question.setTag(addQuestionRequest.getTag());
        question.setAskedBy(userRepository.findById(addQuestionRequest.getUserId()).get());
        question.setAskedDate(new Date());
        question.setVoteCount(0);
        question.setAnswerCount(0);
        return questionRepository.save(question).getId();
    }

    public QuestionDetailDto getById(Integer id) {
        Question question = questionRepository.findById(id).get();
        QuestionDetailDto q = questionMapper.questionToQuestionDetailDto(question);
        return questionMapper.
                questionToQuestionDetailDto(questionRepository.
                        findById(id).orElseThrow(
                                () -> new NullPointerException("No such id")));
    }

    public List<QuestionDto> getAllByTags(String tag) {
        List<Question> questions = questionRepository.findAllByTag(tag);
        List<QuestionDto> questionDtos = new ArrayList<>();
        for (Question question: questions) {
            questionDtos.add(questionMapper.questionToQuestionDto(question));
        }
        return questionDtos;
    }

    public Integer voteQuestion(Integer questionId) {
        Question question = questionRepository.findById(questionId).get();
        question.setVoteCount(question.getVoteCount() + 1);
        questionRepository.save(question);
        return question.getVoteCount();
    }

}
