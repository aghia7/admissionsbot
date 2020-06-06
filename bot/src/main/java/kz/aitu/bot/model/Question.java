package kz.aitu.bot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "faq")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_rus")
    private String questionRus;

    @Column(name = "question_kaz")
    private String questionKaz;

    @Column(name = "question_eng")
    private String questionEng;

    @Column(name = "answer_rus")
    private String answerRus;

    @Column(name = "answer_kaz")
    private String answerKaz;

    @Column(name = "answer_eng")
    private String answerEng;

    @Column(name = "question_counter")
    private int questionCounter;

    @Column(name = "category_question_id")
    private long categoryId;


}
