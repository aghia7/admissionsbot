package kz.aitu.bot.rest;

import kz.aitu.bot.dtos.QuestionDTO;
import kz.aitu.bot.model.Language;
import kz.aitu.bot.model.Question;
import kz.aitu.bot.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/questions/")
public class QuestionRestController {

    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "{lang}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionDTO> getQuestionLang(@PathVariable("lang") String lang, @PathVariable("id") Long questionId) {
        if (questionId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Question question = this.questionService.getById(questionId);

        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            lang = lang.toUpperCase(); //KAZ RUS ENG
            lang = lang.replaceAll("\\s", "");
            return new ResponseEntity<>(new QuestionDTO(question, Language.valueOf(lang)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new QuestionDTO(question, Language.RUS), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/lang/{lang}/question", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionDTO> getAnswerByQuestionLang(@PathVariable("lang") String lang, @RequestParam("question") String questionAsked) {
        if (questionAsked == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Question question = this.questionService.getAnswerByQuestion(questionAsked);

        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            lang = lang.toUpperCase(); //KAZ RUS ENG
            lang = lang.replaceAll("\\s", "");
            return new ResponseEntity<>(new QuestionDTO(question, Language.valueOf(lang)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new QuestionDTO(question, Language.RUS), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionDTO> getQuestion(@PathVariable("id") Long questionId) {
        if (questionId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Question question = this.questionService.getById(questionId);

        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new QuestionDTO(question, Language.RUS), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = this.questionService.findAll();

        if (questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @RequestMapping(value = "/lang/{lang}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuestionDTO>> getAllQuestionsLang(@PathVariable("lang") String lang) {
        List<Question> questions = this.questionService.findAll();
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        if (questions.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            lang = lang.toUpperCase();
            lang = lang.replaceAll("\\s", "");
            for (Question question : questions) {
                questionDTOS.add(new QuestionDTO(question, Language.valueOf(lang)));
            }

            return new ResponseEntity<>(questionDTOS, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(questionDTOS, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/lang/{lang}/cat/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuestionDTO>> getQuestionsByCategoryIdAndLang(@PathVariable("lang") String lang, @PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Question> questions = questionService.getByCategoryId(id);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        if (questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            lang = lang.toUpperCase();
            lang = lang.replaceAll("\\s", "");
            for (Question question : questions) {
                questionDTOS.add(new QuestionDTO(question, Language.valueOf(lang)));
            }

            return new ResponseEntity<>(questionDTOS, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(questionDTOS, HttpStatus.NOT_FOUND);
        }
    }

    //    @RequestMapping(path = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity addQuestion(Question question) {
//        if(question == null) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//        questionService.addQuestion(question);
//        return new ResponseEntity(question, HttpStatus.OK);
//    }

}
