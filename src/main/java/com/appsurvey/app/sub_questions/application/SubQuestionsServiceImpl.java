package com.appsurvey.app.sub_questions.application;


import com.appsurvey.app.sub_questions.domain.entities.SubQuestions;
import com.appsurvey.app.sub_questions.infrastructure.SubQuestionsRepository;
import com.appsurvey.app.sub_questions.domain.services.SubQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubQuestionsServiceImpl implements SubQuestionsService {

    @Autowired
    private SubQuestionsRepository subQuestionsRepository;

    @Override
    public SubQuestions createSubQuestion(SubQuestions subQuestion) {
        return subQuestionsRepository.save(subQuestion);
    }

    @Override
    public SubQuestions updateSubQuestion(Long id, SubQuestions subQuestion) {
        Optional<SubQuestions> existingSubQuestion = subQuestionsRepository.findById(id);
        if (existingSubQuestion.isPresent()) {
            SubQuestions updatedSubQuestion = existingSubQuestion.get();
            updatedSubQuestion.setSubquestionText(subQuestion.getSubquestionText());
            updatedSubQuestion.setResponseType(subQuestion.getResponseType());
            return subQuestionsRepository.save(updatedSubQuestion);
        } else {
            throw new RuntimeException("SubQuestion not found with id: " + id);
        }
    }

    @Override
    public void deleteSubQuestion(Long id) {
        subQuestionsRepository.deleteById(id);
    }

    @Override
    public SubQuestions getSubQuestionById(Long id) {
        return subQuestionsRepository.findById(id).orElseThrow(() -> new RuntimeException("SubQuestion not found with id: " + id));
    }

    @Override
    public List<SubQuestions> getAllSubQuestions() {
        return subQuestionsRepository.findAll();
    }
}

