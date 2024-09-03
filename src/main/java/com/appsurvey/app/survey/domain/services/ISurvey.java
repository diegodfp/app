package com.appsurvey.app.survey.domain.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appsurvey.app.survey.domain.entities.Survey;

public interface ISurvey {
    Optional <Survey> findBy(long id);

    Page<Survey> findAll(Pageable pageable);

    Optional <Survey> delete(long id);

    Optional<Survey> update(Long id, Survey product);

    Survey createOne(Survey survey);
}
