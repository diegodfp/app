package com.appsurvey.app.sub_questions.infrastructure;

import com.appsurvey.app.sub_questions.domain.entities.SubQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubQuestionsRepository extends JpaRepository<SubQuestions, Long> {
}