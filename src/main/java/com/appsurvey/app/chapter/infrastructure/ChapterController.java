package com.appsurvey.app.chapter.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsurvey.app.chapter.domain.entities.Chapter;
import com.appsurvey.app.chapter.domain.services.IChapter;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    IChapter chapterService;

    //

    @PostMapping("/createOne")
    public Chapter createOne(@RequestBody Chapter chapter) {

        return chapterService.createOne(chapter);
    }

    /*
     * PRUEBA EN IMSONIA - CREAR CAPITULO
     * http://localhost:8080/chapter/createOne
     * 
      {
     "chapterNumber": "1",
     "chapterTitle": "Preguntas Personales",
     "survey": {
      "id": 1
      }
     }

     */
    
    @PutMapping("/updateChapter/{id}")
    public Optional<Chapter> updateOne(@PathVariable Long id, @RequestBody Chapter chapter) {

        return chapterService.update(id, chapter);

    }   

    /*  JSON INSOMNIA
        // http://localhost:8080/chapter/updateChapter/1
     "survey": {
     "id": 1
     },
     "chapterNumber": "01",
     "chapterTitle": "Introducción"
      }
     */

     @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {

        Optional<Chapter> surveyOptional = chapterService.delete(id);

        if (surveyOptional.isPresent()) {

            return "Capitulo numero : " + id + " ha sido eliminado";
        }

        return "Capitulo numero : " + id + " no existe ";

    }

    // http://localhost:8080/chapter/deleteOne/1

    



    // http://localhost:8080/chapter/findOne/1

    @GetMapping("/findOne/{id}")
    public Optional<Chapter> findOne(@PathVariable long id) {

        return chapterService.findById(id);
    }

    // http://localhost:8080/chapter/findChapterBySurveyId/1

    @GetMapping("/findChapterBySurveyId/{id}")
    public List<Chapter> findChapterBySurveyId(@PathVariable Long id) {

        return chapterService.findChaptersByIdSurvey(id);
    }
}
