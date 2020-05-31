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
        return questionRepository.getOne(id);
    }

    @Override
    public List<Question> getByCategoryId(Long id) {
        return null;
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
