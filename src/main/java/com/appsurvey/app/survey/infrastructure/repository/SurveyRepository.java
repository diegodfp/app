package com.appsurvey.app.survey.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsurvey.app.survey.domain.entities.Survey;

public interface SurveyRepository  extends JpaRepository <Survey , Long> {

}
