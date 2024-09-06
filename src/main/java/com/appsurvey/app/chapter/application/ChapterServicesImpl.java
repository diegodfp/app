package com.appsurvey.app.chapter.application;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.appsurvey.app.chapter.domain.entities.Chapter;
import com.appsurvey.app.chapter.domain.services.IChapter;
import com.appsurvey.app.chapter.infrastructure.ChapterRepository;



@Service
public class ChapterServicesImpl implements IChapter{


    @Autowired
    ChapterRepository chapterRepository;

    @Override
    public Optional<Chapter> findById(Long id) {
        // TODO Auto-generated method stub
        return chapterRepository.findById(id);
    }



    @Override
    public Chapter createOne(Chapter chapter) {
        
        return chapterRepository.save(chapter);
    }


    @Override
    public List<Chapter> findChaptersByIdSurvey(Long idSurvey) {
        return chapterRepository.buscarByChapterByIdSurvey(idSurvey);
    }

    @Override
    public Optional<Chapter> update(Long id, Chapter chapter) {

        Optional<Chapter> chapterOptional = chapterRepository.findById(id);

        if (chapterOptional.isPresent()) {
            
            Chapter chapterDb = chapterOptional.orElseThrow();
            
            //chapterDb.setChapterNumber(chapter.getChapterNumber());
            chapterDb.setChapterTitle(chapter.getChapterTitle());

            return Optional.of(chapterRepository.save(chapterDb));
            
        }
        return chapterOptional;
    }



    @Override
    @Transactional
    public Optional<Chapter> delete(Long id) {

        Optional<Chapter> chapterOptional = chapterRepository.findById(id);

        chapterOptional.ifPresent(chapterdb -> {

            chapterRepository.delete(chapterdb);

        });
        return chapterOptional;
    }


}
