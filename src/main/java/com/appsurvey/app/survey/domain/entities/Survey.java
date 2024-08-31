package com.appsurvey.app.survey.domain.entities;

import java.util.List;

import com.appsurvey.app.categories_catalog.domain.entities.CategoriesCatalog;
import com.appsurvey.app.chapter.domain.entities.Chapter;
import com.appsurvey.app.common.domain.embeddable.TimeCreateUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "surveys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Survey {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "componenthtml", length = 20)
    private String componentHtml;

    @Column(name = "componentreact", length = 20)
    private String componentReact;


    @Embedded
    private TimeCreateUpdate timeCreateUpdate;

    @ManyToMany
    @JoinTable(name = "survey_category", joinColumns = @JoinColumn(name = "survey_id"), inverseJoinColumns = @JoinColumn(name = "category_id"), uniqueConstraints = {
            @UniqueConstraint(columnNames = { "survey_id", "category_id" }) })
    private List<CategoriesCatalog> categoriesCatalogs;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;    
}
