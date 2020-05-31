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
    private String question_rus;

    @Column(name = "question_kaz")
    private String question_kaz;

    @Column(name = "question_eng")
    private String question_eng;

    @Column(name = "answer_rus")
    private String answer_rus;

    @Column(name = "answer_kaz")
    private String answer_kaz;

    @Column(name = "answer_eng")
    private String answer_eng;

    @Column(name = "question_counter")
    private int question_counter;

    @Column(name = "category_id")
    private long category_id;


}
