package kz.aitu.bot.dtos;

import kz.aitu.bot.model.Language;
import kz.aitu.bot.model.Question;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String question;
    private String answer;
    private Long categoryId;

    public QuestionDTO(Question question, Language lang) {
        this.setId(question.getId());
        if (lang == Language.KAZ) {
            this.setQuestion(question.getQuestion_kaz());
            this.setAnswer(question.getAnswer_kaz());
        } else if (lang == Language.ENG) {
            this.setQuestion(question.getQuestion_eng());
            this.setAnswer(question.getAnswer_eng());
        } else {
            this.setQuestion(question.getQuestion_rus());
            this.setAnswer(question.getAnswer_rus());
        }
    }

}
