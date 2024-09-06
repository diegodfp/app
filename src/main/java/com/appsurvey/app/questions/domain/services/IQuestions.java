package com.appsurvey.app.questions.domain.services;

import com.appsurvey.app.questions.domain.entities.Questions;

import java.util.List;
import java.util.Optional;

public interface IQuestions {
    Optional<Questions> findById(Long id);
    Questions createOne(Questions questions);
    List<Questions> findByChapterId(Long chapterId);
    Optional<Questions> update(Long id, Questions questions);
    Optional<Questions> delete(Long id);
}
