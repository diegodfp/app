package com.appsurvey.app.sub_questions.domain.entities;

import java.util.List;

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
@Table(name = "sub_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TimeCreateUpdate timeCreateUpdate;

    @ManyToOne
    @JoinColumn(name = "questionsId", nullable = false)
    private Questions questions;

    @Column(columnDefinition = "text")
    private String subquestionText;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String responseType;
}
