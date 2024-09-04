package com.appsurvey.app.questions.domain.entities;




import java.util.List;

import com.appsurvey.app.chapter.domain.entities.Chapter;
import com.appsurvey.app.common.domain.embeddable.TimeCreateUpdate;
import com.appsurvey.app.survey.domain.entities.Survey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TimeCreateUpdate timeCreateUpdate;

    @ManyToOne
    @JoinColumn(name = "chapterId", nullable = false)
    private Chapter chapter;

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String questionNumber;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String responseType;

    @Column(columnDefinition = "text")
    private String  commentQuestion;

    @Column(columnDefinition = "text")
    private String  questionText;

    

}
