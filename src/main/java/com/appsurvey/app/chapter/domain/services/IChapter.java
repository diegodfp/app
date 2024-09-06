package com.appsurvey.app.chapter.domain.services;


import java.util.Optional;

import com.appsurvey.app.chapter.domain.entities.Chapter;

import java.util.List;
public interface IChapter {

    Optional <Chapter> findById(Long id); 
    Chapter createOne (Chapter chapter);
    List<Chapter> findChaptersByIdSurvey(Long idSurvey);
    Optional<Chapter> update(Long id, Chapter chapter);
    Optional <Chapter> delete(Long id);
}
