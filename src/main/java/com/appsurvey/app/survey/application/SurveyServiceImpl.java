package com.appsurvey.app.survey.application;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appsurvey.app.survey.domain.entities.Survey;
import com.appsurvey.app.survey.domain.services.ISurvey;
import com.appsurvey.app.survey.infrastructure.repository.SurveyRepository;

@Service
public class SurveyServiceImpl implements ISurvey{


    @Autowired
    SurveyRepository surveyRepository;

    @Override
    @Transactional
    public Page<Survey> findAll(Pageable pageable) {
        return surveyRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Optional<Survey> findBy(long id) {
        return surveyRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional <Survey> delete(long id) {

        Optional<Survey> surveyOptional = surveyRepository.findById(id);

        surveyOptional.ifPresent(surveydb -> {

            surveyRepository.delete(surveydb);

        });
        return surveyOptional;
  
    }


    @Override
    @Transactional
    public Optional<Survey> update(Long id, Survey product) {
        Optional<Survey> surveyOptional = surveyRepository.findById(id);

        if (surveyOptional.isPresent()) {
            
            Survey surveyDb = surveyOptional.orElseThrow();
            
            surveyDb.setName(product.getName());
            surveyDb.setDescription(product.getDescription());

            return Optional.of(surveyRepository.save(surveyDb));
            
        }
        return surveyOptional;
    }

    @Override
    public Survey createOne(Survey survey) {
        return surveyRepository.save(survey);
    }
}
