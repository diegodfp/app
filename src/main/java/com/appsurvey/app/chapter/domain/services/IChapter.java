package com.appsurvey.app.chapter.domain.services;


import java.util.Optional;

import com.appsurvey.app.chapter.domain.entities.Chapter;

import java.util.List;
public interface IChapter {

    Optional <Chapter> findById(Long id); 
    // Page<Chapter> findAllForChapter(Pageable pageable);
    Chapter createOne (Chapter chapter);
    List<Chapter> findChaptersByIdSurvey(Long idSurvey);

}
