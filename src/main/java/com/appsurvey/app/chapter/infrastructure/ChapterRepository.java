package com.appsurvey.app.chapter.infrastructure;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appsurvey.app.chapter.domain.entities.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query(value = "SELECT * FROM chapter WHERE survey_id = ?1", nativeQuery = true)
    List<Chapter> buscarByChapterByIdSurvey(Long idSurvey);
    

}
