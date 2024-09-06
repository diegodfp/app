package com.appsurvey.app.sub_questions.domain.services;

import com.appsurvey.app.sub_questions.domain.entities.SubQuestions;
import java.util.List;

public interface SubQuestionsService {

    SubQuestions createSubQuestion(SubQuestions subQuestion);

    SubQuestions updateSubQuestion(Long id, SubQuestions subQuestion);

    void deleteSubQuestion(Long id);

    SubQuestions getSubQuestionById(Long id);

    List<SubQuestions> getAllSubQuestions();
}
