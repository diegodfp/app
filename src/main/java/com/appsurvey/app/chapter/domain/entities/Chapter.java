package com.appsurvey.app.chapter.domain.entities;

import java.util.List;

import com.appsurvey.app.categories_catalog.domain.entities.CategoriesCatalog;
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
@Table(name = "chapters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Chapter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TimeCreateUpdate timeCreateUpdate;

    @ManyToOne
    @JoinColumn(name = "surveyId", nullable = false)
    private Survey survey;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String chapterNumber;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String chapterTitle;

    @ManyToMany
    @JoinTable(name = "question_chapters", joinColumns = @JoinColumn(name = "chapter_id"), inverseJoinColumns = @JoinColumn(name = "question_id"), uniqueConstraints = {
            @UniqueConstraint(columnNames = { "chapter_id", "question_id" }) })
    private List<Questions> questions;

    
}
