package kz.aitu.bot.service;

import kz.aitu.bot.model.Question;
import kz.aitu.bot.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImp(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question getAnswerByQuestionRus(String question) {
        return questionRepository.findByQuestionRus(question);
    }

    @Override
    public Question getAnswerByQuestionKaz(String question) {
        return questionRepository.findByQuestionKaz(question);
    }

    @Override
    public Question getAnswerByQuestionEng(String question) {
        return questionRepository.findByQuestionEng(question);
    }

    @Override
    public List<Question> getByCategoryId(Long id) {
        return questionRepository.findByCategoryId(id);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

//      @Override
//    public void addQuestion(Question question) {
//
//        questionRepository.save(question);
//    }

//    @Override
//    public void editQuestion(Question question) {
//        questionRepository.save(question);
//    }
//
//    @Override
//    public void deleteQuestion(Long id) {
//        questionRepository.deleteById(id);
//    }

}
