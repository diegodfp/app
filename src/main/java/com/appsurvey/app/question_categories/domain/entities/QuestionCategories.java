package com.appsurvey.app.question_categories.domain.entities;

import java.util.List;

import com.appsurvey.app.category_options.domain.entities.CategoryOptions;
import com.appsurvey.app.common.domain.embeddable.TimeCreateUpdate;
import com.appsurvey.app.questions.domain.entities.Questions;
import com.appsurvey.app.survey.domain.entities.Survey;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "questionsId", nullable = false)
    private Questions questions;

    @ManyToOne
    @JoinColumn(name = "categoryoptionsId", nullable = false)
    private CategoryOptions categoryOptions;

    @Embedded
    private TimeCreateUpdate timeCreateUpdate;

}
