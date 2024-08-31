package com.appsurvey.app.category_options.domain.entities;

import java.util.List;

import com.appsurvey.app.categories_catalog.domain.entities.CategoriesCatalog;
import com.appsurvey.app.common.domain.embeddable.TimeCreateUpdate;
import com.appsurvey.app.options.domain.entities.Options;
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
@Table(name = "category_options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "optionsId", nullable = false)
    private Options options;

    @ManyToOne
    @JoinColumn(name = "categoriescatalogId", nullable = false)
    private CategoriesCatalog categoriesCatalog;    


    @Embedded
    private TimeCreateUpdate timeCreateUpdate;


}
