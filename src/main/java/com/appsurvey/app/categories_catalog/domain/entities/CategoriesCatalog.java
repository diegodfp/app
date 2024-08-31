package com.appsurvey.app.categories_catalog.domain.entities;

import java.util.List;

import com.appsurvey.app.common.domain.embeddable.TimeCreateUpdate;
import com.appsurvey.app.survey.domain.entities.Survey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories_catalog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriesCatalog {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String name;
    
    @Embedded 
    private TimeCreateUpdate timeCreateUpdate;

     // Se coloca el JsonIgnoreProperties en las relaciones Muchos a Muchos! en donde no se hace la relacion
    @JsonIgnoreProperties({"categories_catalog","handler","hibernateLazyInitializer"})
    @ManyToMany(mappedBy = "categoriesCatalogs") // El mapeo se hacer al nombre que le di a la lista
    private List<Survey> surveys;

}
