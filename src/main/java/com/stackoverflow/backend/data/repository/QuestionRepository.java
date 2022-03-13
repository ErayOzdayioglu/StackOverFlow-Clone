package com.stackoverflow.backend.data.repository;

import com.stackoverflow.backend.data.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findAllByTag(String tag);
}
