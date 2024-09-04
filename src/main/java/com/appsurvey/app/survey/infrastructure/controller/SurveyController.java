package com.appsurvey.app.survey.infrastructure.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsurvey.app.survey.domain.entities.Survey;
import com.appsurvey.app.survey.domain.services.ISurvey;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/survey")
public class SurveyController {

    @Autowired 
    private ISurvey servicio; 
    

 
    
    @GetMapping("/findAll")
    public ResponseEntity< Page<Survey> >findAll(Pageable pageable) {

        return ResponseEntity.ok().body(servicio.findAll(pageable));
    }


    @GetMapping("/findOne/{id}")
    public Optional<Survey> findOne(@PathVariable long id) {

        return servicio.findBy(id);
    }
    



    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {

        Optional<Survey> surveyOptional = servicio.delete(id);
        
        if (surveyOptional.isPresent()) {

            return "Encuesta numero : " + id + " ha sido eliminada";
        }
        return "Encuesta numero : " + id + " no existe ";
    } 

   
    @CrossOrigin(origins = {"http://localhost:4200"})
    @PostMapping("/createSurvey")
    public  Survey createOne(@RequestBody Survey survey) {
        
       return servicio.createOne(survey);

    }



    @PutMapping("/updateSurvey/{id}") 
        public  Optional <Survey> updateOne (@PathVariable Long id , @RequestBody Survey survey) {

            return servicio.update(id, survey);

        }


}
