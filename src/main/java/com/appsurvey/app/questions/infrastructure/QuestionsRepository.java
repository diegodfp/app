package com.appsurvey.app.questions.infrastructure;

import com.appsurvey.app.questions.domain.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    
    @Query(value = "SELECT * FROM questions WHERE chapter_id = ?1", nativeQuery = true)
    List<Questions> findByChapterId(Long chapterId);
}
