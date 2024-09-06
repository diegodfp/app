package com.appsurvey.app.questions.application;

import com.appsurvey.app.questions.domain.entities.Questions;
import com.appsurvey.app.questions.domain.services.IQuestions;
import com.appsurvey.app.questions.infrastructure.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsServiceImpl implements IQuestions {

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public Optional<Questions> findById(Long id) {
        return questionsRepository.findById(id);
    }

    @Override
    public Questions createOne(Questions questions) {
        return questionsRepository.save(questions);
    }

    @Override
    public List<Questions> findByChapterId(Long chapterId) {
        return questionsRepository.findByChapterId(chapterId);
    }

    @Override
    public Optional<Questions> update(Long id, Questions questions) {
        Optional<Questions> questionsOptional = questionsRepository.findById(id);
        if (questionsOptional.isPresent()) {
            Questions questionsDb = questionsOptional.get();
            questionsDb.setQuestionText(questions.getQuestionText());
            questionsDb.setResponseType(questions.getResponseType());
            return Optional.of(questionsRepository.save(questionsDb));
        }
        return questionsOptional;
    }

    @Override
    @Transactional
    public Optional<Questions> delete(Long id) {
        Optional<Questions> questionsOptional = questionsRepository.findById(id);
        questionsOptional.ifPresent(questionsRepository::delete);
        return questionsOptional;
    }
}
