package kz.aitu.bot.service;

import kz.aitu.bot.model.Question;

import java.util.List;

public interface QuestionService {

    Question getById(Long id);

    Question getAnswerByQuestionRus(String question);
    Question getAnswerByQuestionKaz(String question);
    Question getAnswerByQuestionEng(String question);

    List<Question> getByCategoryId(Long id);

    List<Question> findAll();


//    void  addQuestion(Question question);
//
//    void editQuestion(Question question);
//
//    void deleteQuestion(Long id);


}
