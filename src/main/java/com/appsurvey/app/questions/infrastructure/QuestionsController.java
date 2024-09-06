package com.appsurvey.app.questions.infrastructure;

import com.appsurvey.app.questions.domain.entities.Questions;
import com.appsurvey.app.questions.domain.services.IQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    IQuestions questionsService;

    /**
     * http://localhost:8080/questions/createOne
     * Ejemplo de JSON para Insomnia:
      {
        "questionText": "¿Cuál es tu color favorito?",
        "responseType": "text",
        "commentQuestion": "Pregunta sobre gustos personales",
        "questionNumber": "1",
        "chapter": {
           "id": 1
        }
      }
     */
    @PostMapping("/createOne")
    public Questions createOne(@RequestBody Questions questions) {
        return questionsService.createOne(questions);
    }

    /**
     * Ruta: PUT /questions/updateQuestion/{id}
     * JSON para Insomnia:
     {
       "questionText": "¿Cuál es tu color favorito actualizado?",
        "responseType": "text"
      }
     */
    @PutMapping("/updateQuestion/{id}")
    public Optional<Questions> updateOne(@PathVariable Long id, @RequestBody Questions questions) {
        return questionsService.update(id, questions);
    }

    /**
     * Ruta: DELETE /questions/deleteOne/{id}
     * Descripción: Eliminar una pregunta por su ID.
     * No se requiere JSON en el cuerpo de la solicitud. Solo usa la ruta.
     * Ejemplo para Insomnia/Postman: No se necesita body, solo la ruta DELETE.
     */
    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {
        Optional<Questions> questionsOptional = questionsService.delete(id);
        return questionsOptional.isPresent() ? "Pregunta eliminada" : "Pregunta no encontrada";
    }

    /**
     * Ruta: GET /questions/findOne/{id}
     * Descripción: Obtener una pregunta por su ID.
     * No se requiere JSON en el cuerpo de la solicitud. Solo usa la ruta.
     * Ejemplo para Insomnia/Postman: No se necesita body, solo la ruta GET.
     */
    @GetMapping("/findOne/{id}")
    public Optional<Questions> findOne(@PathVariable long id) {
        return questionsService.findById(id);
    }

    /**
     * Ruta: GET /questions/findByChapterId/{chapterId}
     * Descripción: Obtener todas las preguntas asociadas a un capítulo específico por su ID.
     * No se requiere JSON en el cuerpo de la solicitud. Solo usa la ruta.
     * Ejemplo para Insomnia/Postman: No se necesita body, solo la ruta GET.
     */
    @GetMapping("/findByChapterId/{chapterId}")
    public List<Questions> findByChapterId(@PathVariable Long chapterId) {
        return questionsService.findByChapterId(chapterId);
    }
}
