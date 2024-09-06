package com.appsurvey.app.sub_questions.infrastructure;

import com.appsurvey.app.sub_questions.domain.entities.SubQuestions;
import com.appsurvey.app.sub_questions.domain.services.SubQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subquestions")
@CrossOrigin(origins = "http://localhost:4200")
public class SubQuestionsController {

    @Autowired
    private SubQuestionsService subQuestionsService;

    /**
     * Crear subpregunta
     * 
     * POST: http://localhost:8080/subquestions
     * JSON para prueba:
     * {
     *    "subquestionText": "¿Cuál es tu película favorita?",
     *    "responseType": "text",
     *    "questions": {
     *        "id": 1
     *    }
     * }
     */
    @PostMapping
    public ResponseEntity<SubQuestions> createSubQuestion(@RequestBody SubQuestions subQuestion) {
        SubQuestions createdSubQuestion = subQuestionsService.createSubQuestion(subQuestion);
        return ResponseEntity.ok(createdSubQuestion);
    }

    /**
     * Obtener todas las subpreguntas
     * 
     * GET: http://localhost:8080/subquestions
     */
    @GetMapping
    public ResponseEntity<List<SubQuestions>> getAllSubQuestions() {
        List<SubQuestions> subQuestions = subQuestionsService.getAllSubQuestions();
        return ResponseEntity.ok(subQuestions);
    }

    /**
     * Obtener subpregunta por ID
     * 
     * GET: http://localhost:8080/subquestions/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<SubQuestions> getSubQuestionById(@PathVariable Long id) {
        SubQuestions subQuestion = subQuestionsService.getSubQuestionById(id);
        return ResponseEntity.ok(subQuestion);
    }

    /**
     * Actualizar subpregunta
     * 
     * PUT: http://localhost:8080/subquestions/{id}
     * JSON para prueba:
     * {
     *    "subquestionText": "¿Cuál es tu color favorito?",
     *    "responseType": "text",
     *    "questions": {
     *        "id": 1
     *    }
     * }
     */
    @PutMapping("/{id}")
    public ResponseEntity<SubQuestions> updateSubQuestion(@PathVariable Long id, @RequestBody SubQuestions subQuestion) {
        SubQuestions updatedSubQuestion = subQuestionsService.updateSubQuestion(id, subQuestion);
        return ResponseEntity.ok(updatedSubQuestion);
    }

    /**
     * Eliminar subpregunta
     * 
     * DELETE: http://localhost:8080/subquestions/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubQuestion(@PathVariable Long id) {
        subQuestionsService.deleteSubQuestion(id);
        return ResponseEntity.noContent().build();
    }
}

