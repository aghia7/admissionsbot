package kz.aitu.bot.service;

import kz.aitu.bot.model.Question;

import java.util.List;

public interface QuestionService {

    Question getById(Long id);

    List<Question> getByCategoryId(Long id);

    List<Question> findAll();

//    void  addQuestion(Question question);
//
//    void editQuestion(Question question);
//
//    void deleteQuestion(Long id);


}
