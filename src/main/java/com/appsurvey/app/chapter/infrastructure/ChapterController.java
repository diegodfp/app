package com.appsurvey.app.chapter.infrastructure;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsurvey.app.chapter.domain.entities.Chapter;
import com.appsurvey.app.chapter.domain.services.IChapter;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/chapter")
public class ChapterController {

     @Autowired
    IChapter chapterService;


    // http://localhost:8090/chapter/createOne


    /* {
    "chapterNumber": "1",
    "chapterTitle": "Introduction to Surveys",
    "survey": {
        "id": 1
    }
}


*/
    @PostMapping("/createOne")
    public Chapter createOne(@RequestBody Chapter chapter) {
        
        return chapterService.createOne(chapter) ;
    }
    
    // http://localhost:8090/chapter/findOne/1

    @GetMapping("/findOne/{id}")
    public Optional<Chapter>findOne(@PathVariable long id) {
        
        return chapterService.findById(id);
    }

     //  http://localhost:8090/chapter/findChapterBySurveyId/1

    @GetMapping("/findChapterBySurveyId/{id}")
    public List<Chapter>findChapterBySurveyId(@PathVariable Long id) {
        
        return chapterService.findChaptersByIdSurvey(id);
    }
}
