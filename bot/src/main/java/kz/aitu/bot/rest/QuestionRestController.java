package kz.aitu.bot.rest;

import kz.aitu.bot.model.Question;
import kz.aitu.bot.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions/")
public class QuestionRestController {

    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long questionId) {
        if(questionId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Question question = this.questionService.getById(questionId);

        if(question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = this.questionService.findAll();


        if(questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
